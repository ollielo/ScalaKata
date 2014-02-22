package test.scala.FizzBuss

import test.scala.UnitSuite
import main.scala.FizzBuzz.FizzBuzz

class FizzBuzzSuite extends UnitSuite {
  test("We know how to convert a List of Integers into a String") {
    var numbers = (1 to 5).toList
    assertResult(List("1", "2", "3", "4", "5"))(FizzBuzz.toString(numbers))
  }

  test("We can convert multiples of 3 to Fizz") {
    var numbers = (1 to 5).toList
    assertResult(List("1", "2", "Fizz", "4", "5"))(FizzBuzz.toFizz(numbers))
  }

  test("We can convert multiple of 5 to Buzz") {
    var numbers = (1 to 5).toList
    assertResult(List("1", "2", "3", "4", "Buzz"))(FizzBuzz.toBuzz(numbers))
  }

  test("We can convert multiple of 3 and 5 to FizzBuzz") {
    var numbers = List(1, 3, 5, 7, 9, 11, 13, 15)
    assertResult(List("1", "3", "5", "7", "9", "11", "13", "FizzBuzz")) {
      FizzBuzz.toFizzBuzz(numbers)
    }
  }

  test("We can do the FizzBuzz") {
    var numbers = List(1, 3, 5, 11, 15)
    assertResult(List("1", "Fizz", "Buzz", "11", "FizzBuzz")) {
      FizzBuzz(numbers)
    }
  }
}