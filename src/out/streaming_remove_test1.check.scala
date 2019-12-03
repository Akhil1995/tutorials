/*****************************************
Emitting Generated Code
*******************************************/
class Snippet() extends (java.lang.String => Unit) {
  def apply(x0: java.lang.String): Unit = {
    val x1 = new Array[java.lang.String](256)
    var x2 = 0
    val x3 = new Array[Int](256)
    var x4 = -1
    val x5 = new Array[Int](256)
    var x6 = 0
    while (x6 != 256) {
      x5(x6) = -1
      x6 = x6 + 1
    }
    printf("Insert at: ")
    val x7 = "0".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x8 = {
      var x9 = x7
      while (x5(x9) != -1 && !(x1(x5(x9)) == "0")) {
        x9 = x9 + 1 & 255
      }
      val x10 = x9
      if (x5(x10) == -1) {
        val x11 = if (x4 == -1) {
          val x12 = x2
          x2 = x2 + 1
          x12
        } else {
          val x13 = x4
          x4 = x4 - 1
          x3(x13)
        }
        x1(x11) = "0"
        x5(x10) = x11
        x11
      } else x5(x10)
    }
    //# hash_lookup
    printf("%d, ", x8)
    val x14 = "1".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x15 = {
      var x16 = x14
      while (x5(x16) != -1 && !(x1(x5(x16)) == "1")) {
        x16 = x16 + 1 & 255
      }
      val x17 = x16
      if (x5(x17) == -1) {
        val x18 = if (x4 == -1) {
          val x19 = x2
          x2 = x2 + 1
          x19
        } else {
          val x20 = x4
          x4 = x4 - 1
          x3(x20)
        }
        x1(x18) = "1"
        x5(x17) = x18
        x18
      } else x5(x17)
    }
    //# hash_lookup
    printf("%d, ", x15)
    val x21 = "2".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x22 = {
      var x23 = x21
      while (x5(x23) != -1 && !(x1(x5(x23)) == "2")) {
        x23 = x23 + 1 & 255
      }
      val x24 = x23
      if (x5(x24) == -1) {
        val x25 = if (x4 == -1) {
          val x26 = x2
          x2 = x2 + 1
          x26
        } else {
          val x27 = x4
          x4 = x4 - 1
          x3(x27)
        }
        x1(x25) = "2"
        x5(x24) = x25
        x25
      } else x5(x24)
    }
    //# hash_lookup
    printf("%d, ", x22)
    val x28 = "3".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x29 = {
      var x30 = x28
      while (x5(x30) != -1 && !(x1(x5(x30)) == "3")) {
        x30 = x30 + 1 & 255
      }
      val x31 = x30
      if (x5(x31) == -1) {
        val x32 = if (x4 == -1) {
          val x33 = x2
          x2 = x2 + 1
          x33
        } else {
          val x34 = x4
          x4 = x4 - 1
          x3(x34)
        }
        x1(x32) = "3"
        x5(x31) = x32
        x32
      } else x5(x31)
    }
    //# hash_lookup
    printf("%d, ", x29)
    val x35 = "4".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x36 = {
      var x37 = x35
      while (x5(x37) != -1 && !(x1(x5(x37)) == "4")) {
        x37 = x37 + 1 & 255
      }
      val x38 = x37
      if (x5(x38) == -1) {
        val x39 = if (x4 == -1) {
          val x40 = x2
          x2 = x2 + 1
          x40
        } else {
          val x41 = x4
          x4 = x4 - 1
          x3(x41)
        }
        x1(x39) = "4"
        x5(x38) = x39
        x39
      } else x5(x38)
    }
    //# hash_lookup
    printf("%d, ", x36)
    val x42 = "5".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x43 = {
      var x44 = x42
      while (x5(x44) != -1 && !(x1(x5(x44)) == "5")) {
        x44 = x44 + 1 & 255
      }
      val x45 = x44
      if (x5(x45) == -1) {
        val x46 = if (x4 == -1) {
          val x47 = x2
          x2 = x2 + 1
          x47
        } else {
          val x48 = x4
          x4 = x4 - 1
          x3(x48)
        }
        x1(x46) = "5"
        x5(x45) = x46
        x46
      } else x5(x45)
    }
    //# hash_lookup
    printf("%d, ", x43)
    val x49 = "6".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x50 = {
      var x51 = x49
      while (x5(x51) != -1 && !(x1(x5(x51)) == "6")) {
        x51 = x51 + 1 & 255
      }
      val x52 = x51
      if (x5(x52) == -1) {
        val x53 = if (x4 == -1) {
          val x54 = x2
          x2 = x2 + 1
          x54
        } else {
          val x55 = x4
          x4 = x4 - 1
          x3(x55)
        }
        x1(x53) = "6"
        x5(x52) = x53
        x53
      } else x5(x52)
    }
    //# hash_lookup
    printf("%d, ", x50)
    val x56 = "7".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x57 = {
      var x58 = x56
      while (x5(x58) != -1 && !(x1(x5(x58)) == "7")) {
        x58 = x58 + 1 & 255
      }
      val x59 = x58
      if (x5(x59) == -1) {
        val x60 = if (x4 == -1) {
          val x61 = x2
          x2 = x2 + 1
          x61
        } else {
          val x62 = x4
          x4 = x4 - 1
          x3(x62)
        }
        x1(x60) = "7"
        x5(x59) = x60
        x60
      } else x5(x59)
    }
    //# hash_lookup
    printf("%d, ", x57)
    val x63 = "8".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x64 = {
      var x65 = x63
      while (x5(x65) != -1 && !(x1(x5(x65)) == "8")) {
        x65 = x65 + 1 & 255
      }
      val x66 = x65
      if (x5(x66) == -1) {
        val x67 = if (x4 == -1) {
          val x68 = x2
          x2 = x2 + 1
          x68
        } else {
          val x69 = x4
          x4 = x4 - 1
          x3(x69)
        }
        x1(x67) = "8"
        x5(x66) = x67
        x67
      } else x5(x66)
    }
    //# hash_lookup
    printf("%d, ", x64)
    val x70 = "9".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x71 = {
      var x72 = x70
      while (x5(x72) != -1 && !(x1(x5(x72)) == "9")) {
        x72 = x72 + 1 & 255
      }
      val x73 = x72
      if (x5(x73) == -1) {
        val x74 = if (x4 == -1) {
          val x75 = x2
          x2 = x2 + 1
          x75
        } else {
          val x76 = x4
          x4 = x4 - 1
          x3(x76)
        }
        x1(x74) = "9"
        x5(x73) = x74
        x74
      } else x5(x73)
    }
    //# hash_lookup
    printf("%d, ", x71)
    val x77 = "10".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x78 = {
      var x79 = x77
      while (x5(x79) != -1 && !(x1(x5(x79)) == "10")) {
        x79 = x79 + 1 & 255
      }
      val x80 = x79
      if (x5(x80) == -1) {
        val x81 = if (x4 == -1) {
          val x82 = x2
          x2 = x2 + 1
          x82
        } else {
          val x83 = x4
          x4 = x4 - 1
          x3(x83)
        }
        x1(x81) = "10"
        x5(x80) = x81
        x81
      } else x5(x80)
    }
    //# hash_lookup
    printf("%d, ", x78)
    val x84 = "11".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x85 = {
      var x86 = x84
      while (x5(x86) != -1 && !(x1(x5(x86)) == "11")) {
        x86 = x86 + 1 & 255
      }
      val x87 = x86
      if (x5(x87) == -1) {
        val x88 = if (x4 == -1) {
          val x89 = x2
          x2 = x2 + 1
          x89
        } else {
          val x90 = x4
          x4 = x4 - 1
          x3(x90)
        }
        x1(x88) = "11"
        x5(x87) = x88
        x88
      } else x5(x87)
    }
    //# hash_lookup
    printf("%d, ", x85)
    val x91 = "12".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x92 = {
      var x93 = x91
      while (x5(x93) != -1 && !(x1(x5(x93)) == "12")) {
        x93 = x93 + 1 & 255
      }
      val x94 = x93
      if (x5(x94) == -1) {
        val x95 = if (x4 == -1) {
          val x96 = x2
          x2 = x2 + 1
          x96
        } else {
          val x97 = x4
          x4 = x4 - 1
          x3(x97)
        }
        x1(x95) = "12"
        x5(x94) = x95
        x95
      } else x5(x94)
    }
    //# hash_lookup
    printf("%d, ", x92)
    val x98 = "13".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x99 = {
      var x100 = x98
      while (x5(x100) != -1 && !(x1(x5(x100)) == "13")) {
        x100 = x100 + 1 & 255
      }
      val x101 = x100
      if (x5(x101) == -1) {
        val x102 = if (x4 == -1) {
          val x103 = x2
          x2 = x2 + 1
          x103
        } else {
          val x104 = x4
          x4 = x4 - 1
          x3(x104)
        }
        x1(x102) = "13"
        x5(x101) = x102
        x102
      } else x5(x101)
    }
    //# hash_lookup
    printf("%d, ", x99)
    val x105 = "14".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x106 = {
      var x107 = x105
      while (x5(x107) != -1 && !(x1(x5(x107)) == "14")) {
        x107 = x107 + 1 & 255
      }
      val x108 = x107
      if (x5(x108) == -1) {
        val x109 = if (x4 == -1) {
          val x110 = x2
          x2 = x2 + 1
          x110
        } else {
          val x111 = x4
          x4 = x4 - 1
          x3(x111)
        }
        x1(x109) = "14"
        x5(x108) = x109
        x109
      } else x5(x108)
    }
    //# hash_lookup
    printf("%d, ", x106)
    printf("\n")
    printf("In the map: ")
    val x112 = x4
    val x113 = x3.slice(0, (x112 + 1)).sorted
    var x114 = 0
    val x115 = x2
    var x116 = 0
    while (x116 != x115) {
      val x117 = x116
      if (x114 > x112 || x117 != x113(x114)) {
        printf("%s, ", x1(x117))
      } else {
        x114 = x114 + 1
      }
      x116 = x116 + 1
    }
    printf("\n")
    //# hash_lookup
    // generated code for hash lookup
    var x118 = x7
    while (x5(x118) != -1 && !(x1(x5(x118)) == "0")) {
      x118 = x118 + 1 & 255
    }
    val x119 = x118
    val x120 = x5(x119)
    if (x120 != -1) {
      val x121 = x4 + 1
      x4 = x121
      x3(x121) = x120
      x5(x119) = -1
    }
    //# hash_lookup
    //# hash_lookup
    // generated code for hash lookup
    var x122 = x28
    while (x5(x122) != -1 && !(x1(x5(x122)) == "3")) {
      x122 = x122 + 1 & 255
    }
    val x123 = x122
    val x124 = x5(x123)
    if (x124 != -1) {
      val x125 = x4 + 1
      x4 = x125
      x3(x125) = x124
      x5(x123) = -1
    }
    //# hash_lookup
    //# hash_lookup
    // generated code for hash lookup
    var x126 = x49
    while (x5(x126) != -1 && !(x1(x5(x126)) == "6")) {
      x126 = x126 + 1 & 255
    }
    val x127 = x126
    val x128 = x5(x127)
    if (x128 != -1) {
      val x129 = x4 + 1
      x4 = x129
      x3(x129) = x128
      x5(x127) = -1
    }
    //# hash_lookup
    //# hash_lookup
    // generated code for hash lookup
    var x130 = x70
    while (x5(x130) != -1 && !(x1(x5(x130)) == "9")) {
      x130 = x130 + 1 & 255
    }
    val x131 = x130
    val x132 = x5(x131)
    if (x132 != -1) {
      val x133 = x4 + 1
      x4 = x133
      x3(x133) = x132
      x5(x131) = -1
    }
    //# hash_lookup
    //# hash_lookup
    // generated code for hash lookup
    var x134 = x91
    while (x5(x134) != -1 && !(x1(x5(x134)) == "12")) {
      x134 = x134 + 1 & 255
    }
    val x135 = x134
    val x136 = x5(x135)
    if (x136 != -1) {
      val x137 = x4 + 1
      x4 = x137
      x3(x137) = x136
      x5(x135) = -1
    }
    //# hash_lookup
    printf("In the map: ")
    val x138 = x4
    val x139 = x3.slice(0, (x138 + 1)).sorted
    var x140 = 0
    val x141 = x2
    var x142 = 0
    while (x142 != x141) {
      val x143 = x142
      if (x140 > x138 || x143 != x139(x140)) {
        printf("%s, ", x1(x143))
      } else {
        x140 = x140 + 1
      }
      x142 = x142 + 1
    }
    printf("\n")
    printf("Insert at: ")
    val x144 = "15".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x145 = {
      var x146 = x144
      while (x5(x146) != -1 && !(x1(x5(x146)) == "15")) {
        x146 = x146 + 1 & 255
      }
      val x147 = x146
      if (x5(x147) == -1) {
        val x148 = if (x4 == -1) {
          val x149 = x2
          x2 = x2 + 1
          x149
        } else {
          val x150 = x4
          x4 = x4 - 1
          x3(x150)
        }
        x1(x148) = "15"
        x5(x147) = x148
        x148
      } else x5(x147)
    }
    //# hash_lookup
    printf("%d, ", x145)
    val x151 = "16".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x152 = {
      var x153 = x151
      while (x5(x153) != -1 && !(x1(x5(x153)) == "16")) {
        x153 = x153 + 1 & 255
      }
      val x154 = x153
      if (x5(x154) == -1) {
        val x155 = if (x4 == -1) {
          val x156 = x2
          x2 = x2 + 1
          x156
        } else {
          val x157 = x4
          x4 = x4 - 1
          x3(x157)
        }
        x1(x155) = "16"
        x5(x154) = x155
        x155
      } else x5(x154)
    }
    //# hash_lookup
    printf("%d, ", x152)
    val x158 = "17".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x159 = {
      var x160 = x158
      while (x5(x160) != -1 && !(x1(x5(x160)) == "17")) {
        x160 = x160 + 1 & 255
      }
      val x161 = x160
      if (x5(x161) == -1) {
        val x162 = if (x4 == -1) {
          val x163 = x2
          x2 = x2 + 1
          x163
        } else {
          val x164 = x4
          x4 = x4 - 1
          x3(x164)
        }
        x1(x162) = "17"
        x5(x161) = x162
        x162
      } else x5(x161)
    }
    //# hash_lookup
    printf("%d, ", x159)
    val x165 = "18".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x166 = {
      var x167 = x165
      while (x5(x167) != -1 && !(x1(x5(x167)) == "18")) {
        x167 = x167 + 1 & 255
      }
      val x168 = x167
      if (x5(x168) == -1) {
        val x169 = if (x4 == -1) {
          val x170 = x2
          x2 = x2 + 1
          x170
        } else {
          val x171 = x4
          x4 = x4 - 1
          x3(x171)
        }
        x1(x169) = "18"
        x5(x168) = x169
        x169
      } else x5(x168)
    }
    //# hash_lookup
    printf("%d, ", x166)
    val x172 = "19".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x173 = {
      var x174 = x172
      while (x5(x174) != -1 && !(x1(x5(x174)) == "19")) {
        x174 = x174 + 1 & 255
      }
      val x175 = x174
      if (x5(x175) == -1) {
        val x176 = if (x4 == -1) {
          val x177 = x2
          x2 = x2 + 1
          x177
        } else {
          val x178 = x4
          x4 = x4 - 1
          x3(x178)
        }
        x1(x176) = "19"
        x5(x175) = x176
        x176
      } else x5(x175)
    }
    //# hash_lookup
    printf("%d, ", x173)
    val x179 = "20".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x180 = {
      var x181 = x179
      while (x5(x181) != -1 && !(x1(x5(x181)) == "20")) {
        x181 = x181 + 1 & 255
      }
      val x182 = x181
      if (x5(x182) == -1) {
        val x183 = if (x4 == -1) {
          val x184 = x2
          x2 = x2 + 1
          x184
        } else {
          val x185 = x4
          x4 = x4 - 1
          x3(x185)
        }
        x1(x183) = "20"
        x5(x182) = x183
        x183
      } else x5(x182)
    }
    //# hash_lookup
    printf("%d, ", x180)
    val x186 = "21".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x187 = {
      var x188 = x186
      while (x5(x188) != -1 && !(x1(x5(x188)) == "21")) {
        x188 = x188 + 1 & 255
      }
      val x189 = x188
      if (x5(x189) == -1) {
        val x190 = if (x4 == -1) {
          val x191 = x2
          x2 = x2 + 1
          x191
        } else {
          val x192 = x4
          x4 = x4 - 1
          x3(x192)
        }
        x1(x190) = "21"
        x5(x189) = x190
        x190
      } else x5(x189)
    }
    //# hash_lookup
    printf("%d, ", x187)
    printf("\n")
    printf("In the map: ")
    val x193 = x4
    val x194 = x3.slice(0, (x193 + 1)).sorted
    var x195 = 0
    val x196 = x2
    var x197 = 0
    while (x197 != x196) {
      val x198 = x197
      if (x195 > x193 || x198 != x194(x195)) {
        printf("%s, ", x1(x198))
      } else {
        x195 = x195 + 1
      }
      x197 = x197 + 1
    }
    printf("\n")
    //# hash_lookup
    // generated code for hash lookup
    var x199 = x7
    while (x5(x199) != -1 && !(x1(x5(x199)) == "0")) {
      x199 = x199 + 1 & 255
    }
    val x200 = x199
    val x201 = x5(x200)
    if (x201 != -1) {
      val x202 = x4 + 1
      x4 = x202
      x3(x202) = x201
      x5(x200) = -1
    }
    //# hash_lookup
    //# hash_lookup
    // generated code for hash lookup
    var x203 = x28
    while (x5(x203) != -1 && !(x1(x5(x203)) == "3")) {
      x203 = x203 + 1 & 255
    }
    val x204 = x203
    val x205 = x5(x204)
    if (x205 != -1) {
      val x206 = x4 + 1
      x4 = x206
      x3(x206) = x205
      x5(x204) = -1
    }
    //# hash_lookup
    //# hash_lookup
    // generated code for hash lookup
    var x207 = x49
    while (x5(x207) != -1 && !(x1(x5(x207)) == "6")) {
      x207 = x207 + 1 & 255
    }
    val x208 = x207
    val x209 = x5(x208)
    if (x209 != -1) {
      val x210 = x4 + 1
      x4 = x210
      x3(x210) = x209
      x5(x208) = -1
    }
    //# hash_lookup
    //# hash_lookup
    // generated code for hash lookup
    var x211 = x70
    while (x5(x211) != -1 && !(x1(x5(x211)) == "9")) {
      x211 = x211 + 1 & 255
    }
    val x212 = x211
    val x213 = x5(x212)
    if (x213 != -1) {
      val x214 = x4 + 1
      x4 = x214
      x3(x214) = x213
      x5(x212) = -1
    }
    //# hash_lookup
    //# hash_lookup
    // generated code for hash lookup
    var x215 = x91
    while (x5(x215) != -1 && !(x1(x5(x215)) == "12")) {
      x215 = x215 + 1 & 255
    }
    val x216 = x215
    val x217 = x5(x216)
    if (x217 != -1) {
      val x218 = x4 + 1
      x4 = x218
      x3(x218) = x217
      x5(x216) = -1
    }
    //# hash_lookup
    //# hash_lookup
    // generated code for hash lookup
    var x219 = x144
    while (x5(x219) != -1 && !(x1(x5(x219)) == "15")) {
      x219 = x219 + 1 & 255
    }
    val x220 = x219
    val x221 = x5(x220)
    if (x221 != -1) {
      val x222 = x4 + 1
      x4 = x222
      x3(x222) = x221
      x5(x220) = -1
    }
    //# hash_lookup
    //# hash_lookup
    // generated code for hash lookup
    var x223 = x165
    while (x5(x223) != -1 && !(x1(x5(x223)) == "18")) {
      x223 = x223 + 1 & 255
    }
    val x224 = x223
    val x225 = x5(x224)
    if (x225 != -1) {
      val x226 = x4 + 1
      x4 = x226
      x3(x226) = x225
      x5(x224) = -1
    }
    //# hash_lookup
    //# hash_lookup
    // generated code for hash lookup
    var x227 = x186
    while (x5(x227) != -1 && !(x1(x5(x227)) == "21")) {
      x227 = x227 + 1 & 255
    }
    val x228 = x227
    val x229 = x5(x228)
    if (x229 != -1) {
      val x230 = x4 + 1
      x4 = x230
      x3(x230) = x229
      x5(x228) = -1
    }
    //# hash_lookup
    printf("In the map: ")
    val x231 = x4
    val x232 = x3.slice(0, (x231 + 1)).sorted
    var x233 = 0
    val x234 = x2
    var x235 = 0
    while (x235 != x234) {
      val x236 = x235
      if (x233 > x231 || x236 != x232(x233)) {
        printf("%s, ", x1(x236))
      } else {
        x233 = x233 + 1
      }
      x235 = x235 + 1
    }
    printf("\n")
    printf("Insert at: ")
    val x237 = "22".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x238 = {
      var x239 = x237
      while (x5(x239) != -1 && !(x1(x5(x239)) == "22")) {
        x239 = x239 + 1 & 255
      }
      val x240 = x239
      if (x5(x240) == -1) {
        val x241 = if (x4 == -1) {
          val x242 = x2
          x2 = x2 + 1
          x242
        } else {
          val x243 = x4
          x4 = x4 - 1
          x3(x243)
        }
        x1(x241) = "22"
        x5(x240) = x241
        x241
      } else x5(x240)
    }
    //# hash_lookup
    printf("%d, ", x238)
    val x244 = "23".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x245 = {
      var x246 = x244
      while (x5(x246) != -1 && !(x1(x5(x246)) == "23")) {
        x246 = x246 + 1 & 255
      }
      val x247 = x246
      if (x5(x247) == -1) {
        val x248 = if (x4 == -1) {
          val x249 = x2
          x2 = x2 + 1
          x249
        } else {
          val x250 = x4
          x4 = x4 - 1
          x3(x250)
        }
        x1(x248) = "23"
        x5(x247) = x248
        x248
      } else x5(x247)
    }
    //# hash_lookup
    printf("%d, ", x245)
    val x251 = "24".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x252 = {
      var x253 = x251
      while (x5(x253) != -1 && !(x1(x5(x253)) == "24")) {
        x253 = x253 + 1 & 255
      }
      val x254 = x253
      if (x5(x254) == -1) {
        val x255 = if (x4 == -1) {
          val x256 = x2
          x2 = x2 + 1
          x256
        } else {
          val x257 = x4
          x4 = x4 - 1
          x3(x257)
        }
        x1(x255) = "24"
        x5(x254) = x255
        x255
      } else x5(x254)
    }
    //# hash_lookup
    printf("%d, ", x252)
    val x258 = "25".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x259 = {
      var x260 = x258
      while (x5(x260) != -1 && !(x1(x5(x260)) == "25")) {
        x260 = x260 + 1 & 255
      }
      val x261 = x260
      if (x5(x261) == -1) {
        val x262 = if (x4 == -1) {
          val x263 = x2
          x2 = x2 + 1
          x263
        } else {
          val x264 = x4
          x4 = x4 - 1
          x3(x264)
        }
        x1(x262) = "25"
        x5(x261) = x262
        x262
      } else x5(x261)
    }
    //# hash_lookup
    printf("%d, ", x259)
    val x265 = "26".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x266 = {
      var x267 = x265
      while (x5(x267) != -1 && !(x1(x5(x267)) == "26")) {
        x267 = x267 + 1 & 255
      }
      val x268 = x267
      if (x5(x268) == -1) {
        val x269 = if (x4 == -1) {
          val x270 = x2
          x2 = x2 + 1
          x270
        } else {
          val x271 = x4
          x4 = x4 - 1
          x3(x271)
        }
        x1(x269) = "26"
        x5(x268) = x269
        x269
      } else x5(x268)
    }
    //# hash_lookup
    printf("%d, ", x266)
    val x272 = "27".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x273 = {
      var x274 = x272
      while (x5(x274) != -1 && !(x1(x5(x274)) == "27")) {
        x274 = x274 + 1 & 255
      }
      val x275 = x274
      if (x5(x275) == -1) {
        val x276 = if (x4 == -1) {
          val x277 = x2
          x2 = x2 + 1
          x277
        } else {
          val x278 = x4
          x4 = x4 - 1
          x3(x278)
        }
        x1(x276) = "27"
        x5(x275) = x276
        x276
      } else x5(x275)
    }
    //# hash_lookup
    printf("%d, ", x273)
    val x279 = "28".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x280 = {
      var x281 = x279
      while (x5(x281) != -1 && !(x1(x5(x281)) == "28")) {
        x281 = x281 + 1 & 255
      }
      val x282 = x281
      if (x5(x282) == -1) {
        val x283 = if (x4 == -1) {
          val x284 = x2
          x2 = x2 + 1
          x284
        } else {
          val x285 = x4
          x4 = x4 - 1
          x3(x285)
        }
        x1(x283) = "28"
        x5(x282) = x283
        x283
      } else x5(x282)
    }
    //# hash_lookup
    printf("%d, ", x280)
    val x286 = "29".hashCode.toInt & 255
    //# hash_lookup
    // generated code for hash lookup
    val x287 = {
      var x288 = x286
      while (x5(x288) != -1 && !(x1(x5(x288)) == "29")) {
        x288 = x288 + 1 & 255
      }
      val x289 = x288
      if (x5(x289) == -1) {
        val x290 = if (x4 == -1) {
          val x291 = x2
          x2 = x2 + 1
          x291
        } else {
          val x292 = x4
          x4 = x4 - 1
          x3(x292)
        }
        x1(x290) = "29"
        x5(x289) = x290
        x290
      } else x5(x289)
    }
    //# hash_lookup
    printf("%d, ", x287)
    printf("\n")
    printf("In the map: ")
    val x293 = x4
    val x294 = x3.slice(0, (x293 + 1)).sorted
    var x295 = 0
    val x296 = x2
    var x297 = 0
    while (x297 != x296) {
      val x298 = x297
      if (x295 > x293 || x298 != x294(x295)) {
        printf("%s, ", x1(x298))
      } else {
        x295 = x295 + 1
      }
      x297 = x297 + 1
    }
    printf("\n")
  }
}
/*****************************************
End of Generated Code
*******************************************/
