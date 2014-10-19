package test.scla.StringCalculator

import main.scala.StringCalculator.StringCalculator
import test.scala.UnitSpec

class StringCalculatorSpec extends UnitSpec {
  describe("StringCalculator") {
    it("Should return 0 for an empty String") {
      StringCalculator("") should equal(0)
    }
  }
}
