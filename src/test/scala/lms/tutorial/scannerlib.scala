package scala.lms.tutorial

import java.io.FileReader
import java.io.BufferedReader
import scala.util.control.Breaks._

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
