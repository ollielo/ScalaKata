package main.scala.PrimeFactors

object PrimeFactors {
  def apply(number: Int): List[Int] = {
    require(number > 0)

    number match {
      case 1 => List()
      case 2 => List(2)
    }
  }
}
