package test.scla.StringCalculator

import main.scala.StringCalculator.{NegativeNumberException, StringCalculator}
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

    it("Should return the sum for an unknown amount of numbers delimited by commas") {
      StringCalculator("1,2,3,4,5") should equal(15)
    }

    it("Should support using the newline character as delimiters too") {
      StringCalculator("1\n2,3") should equal(6)
    }

    it("Should support user specified delimiter") {
      StringCalculator("//;\n1;2") should equal(3)
    }

    it("Should throw an exception when given a negative number") {
      an[NegativeNumberException] should be thrownBy {
        StringCalculator("1,-2,3")
      }
    }
  }
}
