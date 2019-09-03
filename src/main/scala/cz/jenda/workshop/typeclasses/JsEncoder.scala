package cz.jenda.workshop.typeclasses

import scala.annotation.implicitNotFound

@implicitNotFound("Could not find encoder of ${A} to JSON")
trait JsEncoder[A] {
  def encode(value: A): String
}

object JsEncoder {
  def encode[A](value: A)(implicit se: JsEncoder[A]): String = se.encode(value)

  // TODO implement
}
