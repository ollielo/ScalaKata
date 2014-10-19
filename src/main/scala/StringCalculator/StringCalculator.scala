package main.scala.StringCalculator

object StringCalculator {
  def apply(input: String): Int =
    if (input.isEmpty) 0
    else input.split("[,\n]").map(_.toInt).sum
}
