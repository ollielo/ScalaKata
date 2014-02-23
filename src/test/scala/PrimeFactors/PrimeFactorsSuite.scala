package test.scala.PrimeFactors

import test.scala.UnitSuite
import main.scala.PrimeFactors.PrimeFactors

class PrimeFactorsSuite extends UnitSuite {
  test("1 does not have any prime factors") {
    assertResult(Nil)(PrimeFactors(1))
  }
}
