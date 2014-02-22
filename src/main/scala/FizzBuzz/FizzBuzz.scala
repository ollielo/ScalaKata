package main.scala.FizzBuzz

object FizzBuzz {
  type Element = Either[String, Int]

  def toString(elements: List[Element]): List[String] = {
    // Remove the constructor of Either by pattern matching
    elements map (x => (x match {
      case Left(y)  => y
      case Right(y) => y
    }).toString)
  }

  def toFizz(numbers: List[Int]): List[String] = {
    val elements = numbers map (x => if (x % 3 == 0) Left("Fizz") else Right(x))
    toString(elements)
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