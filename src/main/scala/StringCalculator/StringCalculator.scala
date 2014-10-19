package main.scala.StringCalculator

case class NegativeNumberException(msg: String) extends Exception(msg)

object StringCalculator {

  def apply(input: String): Int = {
    val delimiter_extractor = "//(.*)\n(.*)".r

    val numbers = (input match {
      case "" => "0"
      case delimiter_extractor(delimiter, numbers) =>
        numbers.replace(delimiter, ",")
      case _ => input
    }).split("[,\n]").map(_.toInt)

    if (numbers.exists(_ < 0))
      throw NegativeNumberException("")
    else
      numbers.sum
  }
}
