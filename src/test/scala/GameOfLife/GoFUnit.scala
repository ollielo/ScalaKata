package test.scala.GameOfLife

import test.scala.UnitSuite
import main.scala.GameOfLife.GoF
import main.scala.GameOfLife.GoFReader
import main.scala.GameOfLife.Simulate

class GoFUnit extends UnitSuite {
  val dir = "src/test/resources/game_of_life/"

  private def getGoF(filename: String): GoF = {
    val maybeGoF = GoFReader(filename)
    maybeGoF match {
      case Some(gof) => gof
      case None      => fail("Expected Some[GoF], got None")
    }
  }

  test("4 by 4 still life is a fixed point") {
    val gof = getGoF(dir + "4by4_still_life.txt")

    val next = Simulate(gof)

    assertResult(gof)(next)
  }
}