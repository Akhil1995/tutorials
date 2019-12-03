/*****************************************
    Emitting Generated Code
  *******************************************/

class Snippet() extends (java.lang.String => Unit) {
  def apply(x0: java.lang.String): Unit = {
    println("key,count")
    val x1 = new Array[java.lang.String](256)
    var x2 = 0
    val x3 = new Array[Int](256)
    var x4 = 0
    while (x4 != 256) {
      x3(x4) = -1
      x4 = x4 + 1

    }
    val x5 = new Array[Int](256)
    System.nanoTime / 1000L
    (new scala.lms.tutorial.EventHandler(Seq(5000), ("localhost", 8080))).run({ (x6: Int, x7: scala.lms.tutorial.StringScanner) =>
      x6 match {
        case 0 =>
          val x8 = x7.next(',')
          val x9 = x8.hashCode.toInt & 255
          //# hash_lookup
          // generated code for hash lookup
          val x10 = {
            var x11 = x9
            while (x3(x11) != -1 && !(x1(x3(x11)) == x8)) {
              x11 = x11 + 1 & 255

            }
            if (x3(x11) == -1) {
              val x12 = x2
              x1(x12) = x8
              x2 = x2 + 1
              x3(x11) = x12
              x5(x12) = 0
              x12
            } else x3(x11)
          }
          //# hash_lookup
          x5(x10) = x5(x10) + (x7.next('\n')).toInt
        case _ =>
          val x13 = x2
          var x14 = 0
          while (x14 != x13) {
            val x15 = x14
            printf("%s,%s\n", x1(x15), x5(x15).toString)
            x14 = x14 + 1

          }
          x2 = 0
          var x16 = 0
          while (x16 != 256) {
            x3(x16) = -1
            x16 = x16 + 1

          }
      }

    })

  }
}
