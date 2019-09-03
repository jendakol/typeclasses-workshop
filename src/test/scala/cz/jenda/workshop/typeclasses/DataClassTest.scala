package cz.jenda.workshop.typeclasses

import org.scalatest.{FlatSpec, Matchers}

class DataClassTest extends FlatSpec with Matchers {

  it should "encode DataClass" in {
    val enc = implicitly[JsEncoder[DataClass]]

    val instance = DataClass(i = 42, s = "hello", arr = Seq(true, true, false))

    enc.encode(instance) should be
    """
        |{
        |  "i": 42,
        |  "s": "hello",
        |  "arr": [true, true, false]
        |}
        |""".stripMargin
  }
}
