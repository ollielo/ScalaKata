package main.scala.FizzBuzz

object FizzBuzz {
  def toString(numbers: List[Int]): List[String] = {
    numbers map (x => x.toString)
  }

  def toFizz(numbers: List[Int]): List[String] = {
    numbers map (x => if (x % 3 == 0) "Fizz" else x.toString)
  }

  def toBuzz(numbers: List[Int]): List[String] = {
    numbers map (x => if (x % 5 == 0) "Buzz" else x.toString)
  }

  def toFizzBuzz(numbers: List[Int]): List[String] = {
    numbers map (x => if (x % 3 == 0 && x % 5 == 0) "FizzBuzz" else x.toString)
  }

  def apply(numbers: List[Int]): List[String] = {
    numbers map (x => if (x % 3 == 0 && x % 5 == 0) "FizzBuzz"
    else if (x % 3 == 0) "Fizz"
    else if (x % 5 == 0) "Buzz"
    else x.toString)
  }
}