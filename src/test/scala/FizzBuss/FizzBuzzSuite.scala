package test.scala.FizzBuss

import main.scala.FizzBuzz.FizzBuzz
import test.scala.UnitSuite

class FizzBuzzSuite extends UnitSuite {
  test("We know how to convert a List of Int as Either[String, Int] into a List[String]") {
    val numbers = (1 to 5).toList map (x => Right(x))
    assertResult(List("1", "2", "3", "4", "5")) {
      FizzBuzz.toString(numbers)
    }
  }

  test("We know hot to convert a List of String as Either[String, Int] int a List[String]") {
    val fizzbuzz = List("Fizz", "Buzz", "FizzBuzz")
    val lefts = fizzbuzz map (x => Left(x))
    assertResult(fizzbuzz) {
      FizzBuzz.toString(lefts)
    }
  }

  test("We can convert multiples of 3 to Fizz") {
    val numbers = (1 to 5).toList map (x => Right(x))
    assertResult(List("1", "2", "Fizz", "4", "5")) {
      FizzBuzz.toFizz(numbers)
    }
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