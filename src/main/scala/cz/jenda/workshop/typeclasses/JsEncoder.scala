package cz.jenda.workshop.typeclasses

import scala.annotation.implicitNotFound

@implicitNotFound("Could not find encoder of ${A} to JSON")
trait JsEncoder[A] {
  def encode(value: A): String
}

object JsEncoder {
  def encode[A](value: A)(implicit se: JsEncoder[A]): String = se.encode(value)

  implicit val encInt: JsEncoder[Int] = _.toString
  implicit val encLong: JsEncoder[Long] = _.toString
  implicit val encFloat: JsEncoder[Float] = _.toString
  implicit val encDouble: JsEncoder[Double] = _.toString
  implicit val encBoolean: JsEncoder[Boolean] = _.toString
  implicit val encString: JsEncoder[String] = str => s""""$str""""

  implicit def encSeq[A: JsEncoder]: JsEncoder[Seq[A]] = {
    _.map(JsEncoder.encode[A])
      .mkString("[", ", ", "]")
  }

  implicit def encOption[A: JsEncoder]: JsEncoder[Option[A]] = {
    _.map(_.jsEncoded).getOrElse("null")
  }

  implicit def encTuple[A: JsEncoder]: JsEncoder[(String, A)] = {
    case (key, value) =>
      s""""$key": ${value.jsEncoded}"""
  }

  implicit class JsExtensions[A](val value: A) extends AnyVal {
    def jsEncoded(implicit enc: JsEncoder[A]): String = enc.encode(value)
  }
}
