/*****************************************
  Emitting Generated Code
  *******************************************/
class Snippet extends ((java.lang.String)=>(Unit)) {
  def apply(x0:java.lang.String): Unit = {
    val x1 = println("Phrase,Year")
    val x2 = new Array[java.lang.String](256)
    var x3: Int = 0
    var x4: Int = 0
    val x5 = new Array[Int](256)
    var x7 : Int = 0
    val x10 = while (x7 < 256) {
      val x8 = x5(x7) = -1

      x7 = x7 + 1
    }
    val x11 = new Array[Int](256)
    var x12: Int = 0
    var x13: Int = 0
    val x14 = new scala.lms.tutorial.Timer()
    val x15 = x14.currentTime()
    var x16: Long = x15
    val x17 = new scala.lms.tutorial.Scanner("src/data/t1gram.csv")
    val x84 = while ({true}) {
      val x18 = x17.next('\t')
      val x19 = x17.next('\t')
      val x20 = x17.next('\t')
      val x21 = x17.next('\n')
      val x22 = x18.##
      val x23 = x22.toInt
      val x24 = x23 & 255
      val x53 = {
        //#hash_lookup
        // generated code for hash lookup
        var x25: Int = x24
        val x41 = while ({val x26 = x25
          val x27 = x5(x26)
          val x29 = x27 == -1
          val x34 = if (x29) {
            false
          } else {
            val x30 = x2(x27)
            val x31 = x30 == x18
            val x32 = !x31
            x32
          }
          x34}) {
          val x36 = x25
          val x37 = x36 + 1
          val x38 = x37 & 255
          x25 = x38
          ()
        }
        val x42 = x25
        val x43 = x5(x42)
        val x44 = x43 == -1
        val x51 = if (x44) {
          val x45 = x4
          val x46 = x2(x45) = x18
          val x47 = x4 += 1
          val x48 = x5(x42) = x45
          val x49 = x11(x45) = 0
          x45
        } else {
          x43
        }
        x51
        //#hash_lookup
      }
      val x54 = x11(x53)
      val x55 = x19.toInt
      val x56 = x54 + x55
      val x57 = x11(x53) = x56
      val x58 = x13 += 1
      val x59 = x14.currentTime()
      var x60: Long = x59
      val x61 = x16
      val x62 = x59 - x61
      val x63 = x62 > 5000L
      val x82 = if (x63) {
        val x64 = x4
        var x66 : Int = 0
        val x72 = while (x66 < x64) {
          val x67 = x2(x66)
          val x68 = x11(x66)
          val x69 = (x68).toString()
          val x70 = printf("%s,%s\n",x67,x69)

          x66 = x66 + 1
        }
        x13 = 0
        x4 = 0
        var x75 : Int = 0
        val x78 = while (x75 < 256) {
          val x76 = x5(x75) = -1

          x75 = x75 + 1
        }
        val x79 = x14.currentTime()
        x16 = x79
        ()
      } else {
        ()
      }
      x82
    }
    val x85 = x17.close
    ()
  }
}
