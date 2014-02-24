package main.scala.PrimeFactors

object PrimeFactors {
  def apply(number: Int): List[Int] = {
    require(number > 0)

    def loop(n: Int, p: Int): List[Int] = n match {
      case 1 => List()
      case _ =>
        if (n % p == 0) {
          p :: loop(n / p, p)
        } else {
          loop(n, p + 1)
        }
    }

    loop(number, 2)
  }
}
