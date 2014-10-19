package main.scala.StringCalculator

object StringCalculator {
  val delimiter_extractor = "//(.*)\n(.*)".r

  def apply(input: String): Int = (input match {
    case "" => "0"
    case delimiter_extractor(delimiter, numbers) =>
      numbers.replace(delimiter, ",")
    case _ => input
  }).split("[,\n]").map(_.toInt).sum
}
