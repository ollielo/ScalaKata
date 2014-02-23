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

  test("3 is also the primer factor of itself") {
    assertResult(List(3))(PrimeFactors(3))
  }

  test("4 can be factroed into 2 times 2") {
    assertResult(List(2, 2))(PrimeFactors(4))
  }

  test("6 can be factored into 2 times 3") {
    assertResult(List(2, 3))(PrimeFactors(6))
  }

  test("8 is actually 2 to the power of 3") {
    assertResult(List(2, 2, 2))(PrimeFactors(8))
  }

  test("9 is actually 3 to the power of 3") {
    assertResult(List(3, 3, 3))(PrimeFactors(9))
  }
}
