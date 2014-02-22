package test.scala.FizzBuss

import test.scala.UnitSuite
import main.scala.FizzBuzz.FizzBuzz

class FizzBuzzSuite extends UnitSuite {
  test("We know how to convert a List of Integers into a String") {
    var numbers = (1 to 5).toList
    assertResult(List("1", "2", "3", "4", "5"))(FizzBuzz.toString(numbers))
  }
}