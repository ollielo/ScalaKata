package main.scala.FizzBuzz

object FizzBuzz {
  def toString(numbers: List[Int]): List[String] = {
    numbers map (x => x.toString)
  }
}