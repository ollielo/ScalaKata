package test.scla.StringCalculator

import main.scala.StringCalculator.StringCalculator
import test.scala.UnitSpec

class StringCalculatorSpec extends UnitSpec {
  describe("StringCalculator") {
    it("Should return 0 for an empty String") {
      StringCalculator("") should equal(0)
    }

    it("Should return the number for a single number input") {
      StringCalculator("1") should equal(1)
    }

    it("Should return the sum of two numbers delimited by a comma") {
      StringCalculator("1,2") should equal(3)
    }
  }
}
