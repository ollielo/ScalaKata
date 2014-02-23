package test.scala.FizzBuzz

import main.scala.FizzBuzz.FizzBuzz
import test.scala.UnitSuite

class FizzBuzzSuite extends UnitSuite {
  test("We know how to convert a List of Int as Either[String, Int] into a List[String]") {
    val elements = FizzBuzz.toElement((1 to 5).toList)
    assertResult(List("1", "2", "3", "4", "5")) {
      FizzBuzz.toString(elements)
    }
  }

  test("We know how to convert a List of String as Either[String, Int] int a List[String]") {
    val fizzbuzz = List("Fizz", "Buzz", "FizzBuzz")
    val lefts = FizzBuzz.toElement(fizzbuzz)
    assertResult(fizzbuzz) {
      FizzBuzz.toString(lefts)
    }
  }

  test("We can convert multiples of 3 to Fizz") {
    val elements = FizzBuzz.toElement((1 to 5).toList)
    assertResult(List("1", "2", "Fizz", "4", "5")) {
      FizzBuzz.toString(FizzBuzz.toFizz(elements))
    }
  }

  test("We can convert multiples of 5 to Buzz") {
    val elements = FizzBuzz.toElement((1 to 5).toList)
    assertResult(List("1", "2", "3", "4", "Buzz")) {
      FizzBuzz.toString(FizzBuzz.toBuzz(elements))
    }
  }

  test("We can convert multiples of 3 and 5 to FizzBuzz") {
    val elements = FizzBuzz.toElement(List(1, 3, 5, 7, 9, 11, 13, 15))
    assertResult(List("1", "3", "5", "7", "9", "11", "13", "FizzBuzz")) {
      FizzBuzz.toString(FizzBuzz.toFizzBuzz(elements))
    }
  }

  test("We can do the FizzBuzz") {
    val elements = List(1, 3, 5, 11, 15)
    assertResult(List("1", "Fizz", "Buzz", "11", "FizzBuzz")) {
      FizzBuzz(elements)
    }
  }
}
