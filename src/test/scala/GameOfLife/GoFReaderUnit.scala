package test.scala.GameOfLife

import test.scala.UnitSuite
import main.scala.GameOfLife.GoFReader
import main.scala.GameOfLife.GoF

class GoFReaderUnit extends UnitSuite {
  val dir = "src/test/resources/game_of_life/"

  private def getGoF(filename: String): GoF = {
    val maybeGoF = GoFReader(filename)
    maybeGoF match {
      case Some(gof) => gof
      case None      => fail("Expected Some[GoF], got None")
    }
  }

  test("Reading an empyt file returns None") {
    assertResult(None) {
      GoFReader(dir + "empty.txt")
    }
  }

  test("Reading a file with only 0 0 return None") {
    assertResult(None) {
      GoFReader(dir + "0by0.txt")
    }
  }

  test("Reading a file with 3 by 3 cells returns a 3 by 3 grid") {
    val grid = getGoF(dir + "3by3_1_life.txt")

    assertResult((3, 3))(grid.dims)
  }
}