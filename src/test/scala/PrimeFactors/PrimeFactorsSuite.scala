package test.scala.PrimeFactors

import test.scala.UnitSuite
import main.scala.PrimeFactors.PrimeFactors

class PrimeFactorsSuite extends UnitSuite {
  test("0 or negative numbers are not valid input") {
    intercept[IllegalArgumentException] {
      PrimeFactors(0)
    }
  }

  test("1 does not have any prime factors") {
    assertResult(Nil)(PrimeFactors(1))
  }

  test("2 is the prime factor of itself") {
    assertResult(List(2))(PrimeFactors(2))
  }
}
