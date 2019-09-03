package cz.jenda.workshop.typeclasses

import org.scalatest.{FlatSpec, Matchers}

class DataClassTest extends FlatSpec with Matchers {

  it should "encode DataClass" in {
    val enc = implicitly[JsEncoder[DataClass]]

    // TODO implement
    ???
  }
}
