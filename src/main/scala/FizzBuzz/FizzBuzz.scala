package main.scala.FizzBuzz

object FizzBuzz {
  type Element = Either[String, Int]

  def toString(elements: List[Element]): List[String] = {
    elements map (x => x.fold(l => l, r => r).toString)
  }

  def toFizz(numbers: List[Element]): List[Element] = {
    numbers map (x => x.fold(l => Left(l),
      r => if (r % 3 == 0) Left("Fizz") else x))
  }

  def toBuzz(numbers: List[Element]): List[Element] = {
    numbers map (x => x.fold(l => Left(l),
      r => if (r % 5 == 0) Left("Buzz") else x))
  }

  def toFizzBuzz(numbers: List[Element]): List[Element] = {
    numbers map (x => x.fold(l => Left(l),
      r => if (r % 3 == 0 && r % 5 == 0) Left("FizzBuzz") else x))
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