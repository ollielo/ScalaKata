package test.scala.GameOfLife

import test.scala.UnitSuite

class GoFReaderUnit extends UnitSuite {
  val dir = "src/test/resources/game_of_life"

  test("Reading an empyt file returns None") {
    assertResult(None) {
      GoFReader(dir + "empty.txt")
    }
  }
}