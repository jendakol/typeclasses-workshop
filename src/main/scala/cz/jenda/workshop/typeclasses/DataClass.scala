package cz.jenda.workshop.typeclasses

import JsEncoder._

case class DataClass(i: Int, s: String, arr: Seq[Boolean])

object DataClass {
  implicit val enc: JsEncoder[DataClass] = { dc =>
    s"""
       |{
       |  ${JsEncoder.encode("i" -> dc.i)},
       |  ${JsEncoder.encode("s" -> dc.s)},
       |  ${JsEncoder.encode("arr" -> dc.arr)}
       |}
       |""".stripMargin
  }

//  implicit val enc2: JsEncoder[DataClass] = { dc =>
//    s"""
//       |{
//       |  "i": ${dc.i.jsEncoded},
//       |  "s": ${dc.s.jsEncoded},
//       |  "arr": ${dc.arr.jsEncoded}
//       |}
//       |""".stripMargin
//  }
}
