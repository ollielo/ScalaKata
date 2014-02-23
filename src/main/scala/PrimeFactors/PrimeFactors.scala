package main.scala.PrimeFactors

object PrimeFactors {
  def apply(number: Int): List[Int] = {
    require(number > 0)

    def loop: List[Int] = {
      if (number % 2 == 0) {
        2 :: PrimeFactors(number / 2)
      } else {
        3 :: PrimeFactors(number / 3)
      }
    }
    number match {
      case 1 => List()
      case _ => loop
    }
  }
}
