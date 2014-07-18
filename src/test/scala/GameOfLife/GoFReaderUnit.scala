package test.scala.GameOfLife

import test.scala.UnitSuite
import main.scala.GameOfLife.GoFReader

class GoFReaderUnit extends UnitSuite {
  val dir = "src/test/resources/game_of_life/"

  test("Reading an empyt file returns None") {
    assertResult(None) {
      GoFReader(dir + "empty.txt")
    }
  }

  test("Reading a file with only 0 0 return Nil") {
    assertResult(Nil) {
      GoFReader(dir + "0by0.txt")
    }
  }
}