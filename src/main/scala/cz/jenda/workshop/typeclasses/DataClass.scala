package cz.jenda.workshop.typeclasses

case class DataClass(i: Int, s: String, arr: Seq[Boolean])

object DataClass {
  implicit val enc: JsEncoder[DataClass] = ??? // TODO implement
}
