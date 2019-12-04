/**
Query Compiler II (Scala)
========================

Outline:
<div id="tableofcontents"></div>

*/
package scala.lms.tutorial

import lms.core.stub._
import lms.core.virtualize
import lms.macros.SourceContext

@virtualize
object query_staged {
trait QueryCompiler extends Dsl with StagedQueryProcessor
with ScannerBase {
  override def version = "query_staged"

/**
Low-Level Processing Logic
--------------------------
*/
  type Fields = Vector[Rep[String]]

  case class Record(fields: Fields, schema: Schema) {
    def apply(key: String): Rep[String] = fields(schema indexOf key)
    def apply(keys: Schema): Fields = keys.map(this apply _)
  }

  def processCSV(filename: Rep[String], schema: Schema, fieldDelimiter: Char, externalSchema: Boolean)(yld: Record => Rep[Unit]): Rep[Unit] = {
    val s = newScanner(filename)
    val last = schema.last
    def nextRecord = Record(schema.map{x => s.next(if (x==last) '\n' else fieldDelimiter)}, schema)
    if (!externalSchema) {
      // the right thing would be to dynamically re-check the schema,
      // but it clutters the generated code
      // schema.foreach(f => if (s.next != f) println("ERROR: schema mismatch"))
      nextRecord // ignore csv header
    }
    while (true) yld(nextRecord)
    s.close
  }

  implicit class stringScannerOps(x: Rep[StringScanner]) {
    def escape(d: Char) = d match {
      case '\t' => "'\\t'"
      case '\n' => "'\\n'"
      case _ => s"'$d'"
    }
    def next(d: Char) = unchecked[String](x,raw".next(${escape(d)})")
  }

  class EventHandler {
    val srcs = new scala.collection.mutable.ListBuffer[((String, Int), Rep[StringScanner] => Rep[Unit])]()
    val intervals = new scala.collection.mutable.ListBuffer[(Int, () => Unit)]()

    def isEmpty = srcs.length == 0

    def registerSrc(addr: String, port: Int)(yld: Rep[StringScanner] => Rep[Unit]): Unit = {
      srcs += (((addr, port), yld))
    }

    def registerInterval(i: Int)(yld: => Unit): Unit = {
      assert(intervals.length == 0)
      intervals += ((i, () => yld))
    }
  }

  lazy val eventHandler = new EventHandler
  def registerStreamCSV(addr: String, port: Int, schema: Schema, fieldDelimiter: Char)(yld: Record => Rep[Unit]): Rep[Unit] = {
    val last = schema.last
    eventHandler.registerSrc(addr, port) { (s: Rep[StringScanner]) =>
      yld(Record(schema.map{x => s.next(if (x==last) '\n' else fieldDelimiter)}, schema))
    }
  }

  def printSchema(schema: Schema) = println(schema.mkString(defaultFieldDelimiter.toString))

  def printFields(fields: Fields) = printf(fields.map{_ => "%s"}.mkString("", defaultFieldDelimiter.toString, "\n"), fields: _*)

  def fieldsEqual(a: Fields, b: Fields) = (a zip b).foldLeft(unit(true)) { (a,b) => a && b._1 == b._2 }

  def fieldsHash(a: Fields) = a.foldLeft(unit(0L)) { _ * 41L + _.HashCode }

/**
Query Interpretation = Compilation
----------------------------------
*/
  def evalPred(p: Predicate)(rec: Record): Rep[Boolean] = p match {
    case Eq(a1, a2) => evalRef(a1)(rec) == evalRef(a2)(rec)
  }

  def evalRef(r: Ref)(rec: Record): Rep[String] = r match {
    case Field(name) => rec(name)
    case Value(x) => x.toString
  }

  def resultSchema(o: Operator): Schema = o match {
    case Scan(_, schema, _, _)   => schema
    case Filter(pred, parent)    => resultSchema(parent)
    case Project(schema, _, _)   => schema
    case Join(left, right)       => resultSchema(left) ++ resultSchema(right)
    case Group(keys, agg, parent)=> keys ++ agg
    case HashJoin(left, right)   => resultSchema(left) ++ resultSchema(right)
    case PrintCSV(parent)        => Schema()
  }

  def execOp(o: Operator)(yld: Record => Rep[Unit]): Rep[Unit] = o match {
    case Scan(filename, schema, fieldDelimiter, externalSchema) =>
      // assuming filename: addr_port
      val Array(addr, port) = filename.split("_")
      registerStreamCSV(addr, port.toInt, schema, fieldDelimiter)(yld)
    case Filter(pred, parent) =>
      execOp(parent) { rec => if (evalPred(pred)(rec)) yld(rec) }
    case Project(newSchema, parentSchema, parent) =>
      execOp(parent) { rec => yld(Record(rec(parentSchema), newSchema)) }
    case Join(left, right) =>
      execOp(left) { rec1 =>
        execOp(right) { rec2 =>
          val keys = rec1.schema intersect rec2.schema
          if (fieldsEqual(rec1(keys), rec2(keys)))
            yld(Record(rec1.fields ++ rec2.fields, rec1.schema ++ rec2.schema))
        }
      }
    case Group(keys, agg, parent) =>
      val hm = new HashMapAgg(keys, agg)
      // var cnt = 0
      // var time = timestamp // time should be updated at one point no?
      execOp(parent) { rec =>
        hm(rec(keys)) += rec(agg)
      }
      eventHandler.registerInterval(5000L) {
        hm foreach { (k, a) =>
          val rec1 = new Record(k ++ a, keys ++ agg)
          yld(rec1)
        }
        hm.clear
      }
    case GroupR(keys, agg, parent) =>
      val c = 5
      val hm = new HashMapAgg(keys, agg,c)
      val cnt = var_new(0)
      // var time = timestamp // time should be updated at one point no?
      execOp(parent) { rec =>
        hm(rec(keys), cnt) += rec(agg)
      }
      eventHandler.registerInterval(1000L) {
        // count is the main variable which keeps track of the rolling window
        cnt = (cnt + 1) % c
        hm(cnt) foreach { (k, a) =>
          yld(new Record(k ++ a, keys ++ agg))
        }
      }
    case HashJoin(left, right) =>
      val keys = resultSchema(left) intersect resultSchema(right)
      val hm = new HashMapBuffer(keys, resultSchema(left))
      // another hashmap, quick fix
      execOp(left) { rec1 =>
        hm(rec1(keys)) foreach { rec2 =>
          yld(Record(rec2.fields ++ rec1.fields, rec1.schema ++ rec2.schema))
        }
      }
      execOp(right) { rec2 =>
        hm(rec2(keys)) foreach { rec1 =>
          yld(Record(rec1.fields ++ rec2.fields, rec1.schema ++ rec2.schema))
        }
      }
    case PrintCSV(parent) =>
      val schema = resultSchema(parent)
      printSchema(schema)
      execOp(parent) { rec => printFields(rec.fields) }
  }


  abstract class Handler
  implicit class handlerOps(x: Rep[Handler]) {
    def run(f: (Rep[Int], Rep[StringScanner]) => Rep[Unit]): Unit = {
      val block = Adapter.g.reify(2, xn => Unwrap(f(Wrap[Int](xn(0)), Wrap[StringScanner](xn(1)))))
      Adapter.g.reflect("Handler.run", Unwrap(x), block)
    }
  }

  def execQuery(q: Operator): Unit = {
    execOp(q) { _ => }

    val srcsAddress = eventHandler.srcs.map { case ((addr, port), _) => s"""("$addr", $port)""" }.mkString(",")
    val intervals = eventHandler.intervals.headOption.map { case (i, _) => s"Seq($i)"} getOrElse("Seq(0)")
    val default = eventHandler.intervals.headOption.map { case (_, f) => f }
    val handler = unchecked[Handler](s"new scala.lms.tutorial.EventHandler($intervals, $srcsAddress)")

    handler.run { (streamId: Rep[Int], content: Rep[StringScanner]) =>
      switch(streamId, default) (
        eventHandler.srcs.toSeq.zipWithIndex.map { case ((_, f), idx) => (Seq(idx), { (streamId: Rep[Int]) => f(content); () }) } : _*
      )
    }
  }

/**
Data Structure Implementations
------------------------------
*/

  // defaults for hash sizes etc

  object hashDefaults {
    val hashSize   = (1 << 8)
    val keysSize   = hashSize
    val bucketSize = (1 << 8)
    val dataSize   = keysSize * bucketSize
  }

  // common base class to factor out commonalities of group and join hash tables
  // TODO: add this as a test

  class HashMapBase(keySchema: Schema, schema: Schema, canDelete: Boolean) {
    import hashDefaults._

    val keys = new ArrayBuffer[String](keysSize, keySchema)
    val keyCount = var_new(0)

    val oldKeys = NewArray[Int](keysSize) // used as a LIFO
    val oldKeyCount = var_new(-1)

    val hashMask = hashSize - 1
    val htable = NewArray[Int](hashSize)
    for (i <- 0 until hashSize: Rep[Range]) { htable(i) = -1 } //ambiguous reference to overloaded definition can be fixed with type annotation
    def clear = {
      keyCount = 0
      for (i <- 0 until hashSize: Rep[Range]) { htable(i) = -1 }
    }


    def remove(k: Fields) = {
      if (!canDelete) ???
      lookupPosInternal(k) { pos =>
        val idx = htable(pos)
        if (idx != -1) {
          oldKeyCount += 1
          oldKeys(oldKeyCount) = idx
          htable(pos) = -1
        }
      }
    }
    def lookup(k: Fields) = lookupInternal(k,None)
    def lookupOrUpdate(k: Fields)(init: Rep[Int]=>Rep[Unit]) = lookupInternal(k,Some(init))
    def lookupInternal(k: Fields, init: Option[Rep[Int]=>Rep[Unit]]): Rep[Int] = lookupPosInternal(k) { pos =>
      // FIXME: need use unit and rely on constant folding
      // otherwise the second condition is always false (type differ and no lifting is done)
      // could be nice that if (Boolean && Rep[Boolean]) can be handle correctly
      if (unit(init.isDefined) && htable(pos) == -1) {
        // If key were removed, used empty space
        // otherwise use next available
        val keyPos = if (unit(!canDelete) || oldKeyCount == -1) {
          val keyPos = keyCount: Rep[Int] // force read
          keyCount += 1
          keyPos
        } else {
          val keyPos = oldKeys(oldKeyCount)
          oldKeyCount -= 1
          keyPos
        }
        keys(keyPos) = k
        htable(pos) = keyPos
        init.get(keyPos)
        keyPos
      } else {
        htable(pos)
      }
    }
    def lookupPosInternal[T:Manifest](k: Fields)(action: Rep[Int] => Rep[T]) = {
      comment[T]("hash_lookup") {
        val h = fieldsHash(k).toInt
        var pos = h & hashMask
        while (htable(pos) != -1 && !fieldsEqual(keys(htable(pos)),k)) {
          pos = (pos + 1) & hashMask
        }
        action(pos)
      }
    }
  }

  // hash table for groupBy, storing sums
  class HashMapAgg(keySchema: Schema, schema: Schema, bucketSize: Int = 1, canDelete: Boolean = false) extends HashMapBase(keySchema, schema, canDelete) {
    import hashDefaults._

    val debug = false
    val values = new ArrayBuffer[Int](keysSize, schema, bucketSize) // assuming all summation fields are numeric
    val bitmask = new ArrayBuffer[Boolean](keysSize, Vector("idx"), bucketSize)

    def apply(k: Fields, off: Rep[Int] = 0) = new {
      def +=(v: Fields) = {
        val keyPos = lookupOrUpdate(k) { keyPos =>
          for (off <- 0 until bucketSize: Rep[Range])
            values(keyPos, off) = schema.map(_ => 0:Rep[Int])
        }
        values(keyPos, off) = (values(keyPos, off), v.map(_.toInt)).zipped map (_ + _)
        bitmask(keyPos, off) = unit(true)
      }
    }

    def apply(off: Rep[Int]) = new {
      def foreach(f: (Fields,Fields) => Rep[Unit]) = {
        for (i <- 0 until keyCount) {
          val prevVal = values(i,off)
          for (off1 <- 0 until bucketSize: Rep[Range]) {
            if (off != off1 && bitmask(i, off1))
              values(i, off) = (values(i, off1), values(i, off)).zipped map (_ + _)
          }
          // skip deleted keys
          f(keys(i),values(i, off).map(_.ToString))

          // remove
          values(i, off) = schema.map(_ => 0:Rep[Int])
          bitmask(i, off) = unit(false)
        }
      }
    }

    def foreach(f: (Fields,Fields) => Rep[Unit]): Rep[Unit] = {
      val nbOldKey = oldKeyCount: Rep[Int] // read number of key to make remove foreach safe
      val sOldKeys = oldKeys.sort(nbOldKey + 1) // for now generate .slice(0, lenght).sorted
      var oldKeySeen = 0
      for (i <- 0 until keyCount) {
        // skip deleted keys
        if (unit(!canDelete) || oldKeySeen > nbOldKey || i != sOldKeys(oldKeySeen)) {
          f(keys(i),values(i).map(_.ToString))
        } else {
          oldKeySeen += 1
        }
      }

      if (debug) if (oldKeySeen <= oldKeyCount) printf("Weird!! %d %d\n", oldKeySeen, oldKeyCount)
    }

  }

  // hash table for joins, storing lists of records
  class HashMapBuffer(keySchema: Schema, schema: Schema) extends HashMapBase(keySchema, schema, false) {
    import hashDefaults._

    val data = new ArrayBuffer[String](dataSize, schema)
    val dataCount = var_new(0)

    val buckets = NewArray[Int](dataSize)
    val bucketCounts = NewArray[Int](keysSize)

    def apply(k: Fields) = new {
      def +=(v: Fields) = {
        val dataPos = dataCount: Rep[Int] // force read
        data(dataPos) = v
        dataCount += 1

        val bucket = lookupOrUpdate(k)(bucket => bucketCounts(bucket) = 0)
        val bucketPos = bucketCounts(bucket)
        buckets(bucket * bucketSize + bucketPos) = dataPos
        bucketCounts(bucket) = bucketPos + 1
      }

      def foreach(f: Record => Rep[Unit]): Rep[Unit] = {
        val bucket = lookup(k)

        if (bucket != -1) {
          val bucketLen = bucketCounts(bucket)
          val bucketStart = bucket * bucketSize

          for (i <- bucketStart until (bucketStart + bucketLen)) {
            f(Record(data(buckets(i)),schema))
          }
        }
      }
    }
  }

  class ArrayBuffer[T:Typ](dataSize: Int, schema: Schema,bucketSize:Int = 1) {
    val buf = schema.map(f => NewArray[T](dataSize * bucketSize))
    var len = 0
    def +=(x: Seq[Rep[T]]) = {
      this(len) = x
      len += 1
    }
    //
    def update(i: Rep[Int], x: Seq[Rep[T]]) = {
      (buf,x).zipped.foreach((b,x) => b(i) = x)
    }
    def update(i: Rep[Int], off: Rep[Int], x: Seq[Rep[T]]) = {
      (buf,x).zipped.foreach((b,x) => b(i*bucketSize+off) = x)
    }
    def apply(i: Rep[Int], off:Rep[Int] = 0) = {
      buf.map(b => b(i*bucketSize+off))
    }
  }
}}
