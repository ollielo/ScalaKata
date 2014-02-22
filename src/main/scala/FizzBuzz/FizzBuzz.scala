package main.scala.FizzBuzz

object FizzBuzz {
  type Element = Either[String, Int]

  // FixME: Why does making numbers lazy solve the problem that
  // the type is erased by the compiler?
  def toElement(numbers: => List[Int]): List[Element] =
    numbers map (x => Right(x))

  def toElement(strings: List[String]): List[Element] =
    strings map (x => Left(x))

  def toString(elements: List[Element]): List[String] =
    elements map (x => x.fold(l => l, r => r).toString)

  def toFizz(numbers: List[Element]): List[Element] =
    numbers map (x => x.fold(l => Left(l),
      r => if (r % 3 == 0) Left("Fizz") else x))

  def toBuzz(numbers: List[Element]): List[Element] =
    numbers map (x => x.fold(l => Left(l),
      r => if (r % 5 == 0) Left("Buzz") else x))

  def toFizzBuzz(numbers: List[Element]): List[Element] =
    numbers map (x => x.fold(l => Left(l),
      r => if (r % 3 == 0 && r % 5 == 0) Left("FizzBuzz") else x))

  def apply(numbers: List[Int]): List[String] =
    toString(toFizz(toBuzz(toFizzBuzz(toElement(numbers)))))

  def main(args: Array[String]) {
    val numbers = (1 to 100).toList
    print(FizzBuzz(numbers))
  }
}
