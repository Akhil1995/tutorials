package scala.lms.tutorial

import java.io.FileReader
import java.io.BufferedReader
import scala.util.control.Breaks._

import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels._
import collection.JavaConverters._

class StringScanner(line: String) {
  private[this] var pending: String = line
  def next(delim: Char): String = {
    if (delim == '\n' ) {
      pending
    } else {
      val i = pending.indexOf(delim)
      val field = pending.substring(0,i)
      pending = pending.substring(i+1)
      field
    }
  }
}

class Scanner(filename: String) {
  val br = new BufferedReader(new FileReader(filename))
  private[this] var pending: String = br.readLine()
  def next(delim: Char): String = {
    if(pending == null) {
      // wait for the next call and string to appear
      while (!br.ready()){
        //Thread.sleep(10);
      }
      pending = br.readLine()
    }
    if (delim == '\n' ) {
      val field = pending
      pending = br.readLine()
      field
    } else {
      val i = pending.indexOf(delim)
      val field = pending.substring(0,i)
      pending = pending.substring(i+1)
      field
    }
  }
  def hasNext = pending ne null
  def close = br.close
}

class EventHandler(intervals: Seq[Int], srcs: (String, Int)*) {

  val debug = false
  def run(f: (Int, StringScanner) => Unit) = {

    val selector = Selector.open()
    assert(intervals.length == 1)

    val socks = for ((addr, port) <- srcs) yield {
      val socketChannel = SocketChannel.open()
      socketChannel.connect(new InetSocketAddress(addr, port))
      socketChannel.configureBlocking(false);
      socketChannel.register(selector, SelectionKey.OP_READ);
      socketChannel
    }

    // Needs to do something more clever if more than one interval
    try {
      var time = System.nanoTime + intervals.head * 1000000L
      while (true) {
        var delta = time - System.nanoTime
        if (intervals.head > 0L && delta <= 0L) { // timeout already occurs!!!
          time = System.nanoTime + intervals.head * 1000000L
          f(socks.length, null)
          delta = (time - System.nanoTime) / 1000000L
          assert(delta > 0l, "timeout too short!")
        } else {
          delta /= 1000000L
        }
        val nchannels = selector.select(if (intervals.head == 0) 0L else delta);
        if (intervals.head > 0L && time - System.nanoTime <= 0L) { // timeout!!!
          time = System.nanoTime + intervals.head * 1000000L
          f(socks.length, null)
        }
        for (key <- selector.selectedKeys.asScala) {
          if (key.isReadable) {
            val buffer = ByteBuffer.allocate(256);
            val client = key.channel.asInstanceOf[ReadableByteChannel]
            client.read(buffer)
            val str = new String(buffer.array).trim
            if (debug) println(s"""Accept "${str.map(_.toInt.toHexString).mkString}"""")
            if (str.length > 0) {
              f(socks.indexOf(client), new StringScanner(str))
            }
          }
        }
      }
    } finally {
      socks.foreach(_.close)
    }
  }
}
