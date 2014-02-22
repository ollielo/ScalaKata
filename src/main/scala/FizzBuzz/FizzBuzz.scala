package main.scala.FizzBuzz

object FizzBuzz {
  type Element = Either[String, Int]

  def toString(elements: List[Element]): List[String] = {
    elements map (x => x.fold(l => l, r => r).toString)
  }

  def toFizz(numbers: List[Element]): List[Element] = {
    numbers map (x => x match {
      case Right(y) => if (y % 3 == 0) Left("Fizz") else x
      case Left(_)  => x
    })
  }

  def toBuzz(numbers: List[Element]): List[Element] = {
    numbers map (x => x match {
      case Right(y) => if (y % 5 == 0) Left("Buzz") else x
      case Left(_)  => x
    })
  }

  def toFizzBuzz(numbers: List[Element]): List[Element] = {
    numbers map (x => x match {
      case Right(y) => if (y % 3 == 0 && y % 5 == 0) Left("FizzBuzz") else x
      case _        => x
    })
  }

  def apply(numbers: List[Int]): List[String] = {
    val elements = numbers map (x => Right(x))
    toString(toFizz(toBuzz(toFizzBuzz(elements))))
  }

  def main(args: Array[String]) {
    val numbers = (1 to 100).toList
    print(FizzBuzz(numbers))
  }
}