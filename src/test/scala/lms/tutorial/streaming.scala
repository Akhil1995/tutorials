/**
Streaming database
==============================

In this tutorial, we build up to a distributed word count implementation using MPI.

Outline:
<div id="tableofcontents"></div>

*/
package scala.lms.tutorial

import lms.core.stub._
import lms.core.utils
import lms.macros.SourceContext
import lms.core.virtualize
import scala.collection.{mutable,immutable}

@virtualize
class StreamingTest extends TutorialFunSuite {
  val under = "streaming_"

  test("remove_1") {
    val runner = new DslDriver[String,Unit] with ScannerExp with query_staged.QueryCompiler { q =>
      // override val codegen = new DslGen  {
      //   val IR: q.type = q
      // }
      override def snippet(fn: Rep[String]): Rep[Unit] = {
        implicit def toFields(x: Int) = Vector(unit(x.toString))
        val hm = new HashMapAgg(Vector("key"), Vector(),1, true)

        printf("Insert at: ")
        for (value <- new Range(0, 15, 1)) {
          val pos = hm.lookupOrUpdate(value) { _ => }
          printf("%d, ", pos)
        }
        printf("\n")

        printf("In the map: ")
        hm foreach { (key, value) => printf("%s, ", key.head) }
        printf("\n")

        for (value <- new Range(0, 15, 1)) if (value % 3 == 0) hm.remove(value)

        printf("In the map: ")
        hm foreach { (key, value) => printf("%s, ", key.head) }
        printf("\n")

        printf("Insert at: ")
        for (value <- new Range(15, 22, 1)) {
          val pos = hm.lookupOrUpdate(value) { _ => }
          printf("%d, ", pos)
        }
        printf("\n")

        printf("In the map: ")
        hm foreach { (key, value) => printf("%s, ", key.head) }
        printf("\n")

        for (value <- new Range(0, 22, 1)) if (value % 3 == 0) hm.remove(value)

        printf("In the map: ")
        hm foreach { (key, value) => printf("%s, ", key.head) }
        printf("\n")

        printf("Insert at: ")
        for (value <- new Range(22, 30, 1)) {
          val pos = hm.lookupOrUpdate(value) { _ => }
          printf("%d, ", pos)
        }
        printf("\n")

        printf("In the map: ")
        hm foreach { (key, value) => printf("%s, ", key.head) }
        printf("\n")
      }
    }
    val expected = """compilation: ok
                    |Insert at: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
                    |In the map: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
                    |In the map: 1, 2, 4, 5, 7, 8, 10, 11, 13, 14,
                    |Insert at: 12, 9, 6, 3, 0, 15, 16,
                    |In the map: 19, 1, 2, 18, 4, 5, 17, 7, 8, 16, 10, 11, 15, 13, 14, 20, 21,
                    |In the map: 19, 1, 2, 4, 5, 17, 7, 8, 16, 10, 11, 13, 14, 20,
                    |Insert at: 16, 3, 12, 17, 18, 19, 20, 21,
                    |In the map: 19, 1, 2, 23, 4, 5, 17, 7, 8, 16, 10, 11, 24, 13, 14, 20, 22, 25, 26, 27, 28, 29,""".stripMargin
    val actual = utils.captureOut(runner.eval("ARG")).lines.map(_.trim).toSeq
    assert(actual == expected.split("\n").toSeq)
    check("remove_test1", runner.code, "scala")
  }
}
