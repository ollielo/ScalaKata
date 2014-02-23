package main.scala.PrimeFactors

object PrimeFactors {
  def apply(number: Int): List[Int] = {
    require(number > 0)

    def loop(n: Int, p: Int): List[Int] = {
      if (n == 1) {
        List()
      } else if (n % p == 0) {
        2 :: loop(n / p, p)
      } else {
        3 :: loop(n / p, p + 1)
      }
    }
    number match {
      case 1 => List()
      case _ => loop(number, 2)
    }
  }
}
