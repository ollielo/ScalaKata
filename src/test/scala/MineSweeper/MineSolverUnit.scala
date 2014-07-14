package test.scala.MineSweeper

import main.scala.MineSweeper.MineField
import test.scala.UnitSuite
import main.scala.MineSweeper.MineSolver

class MineSolverUnit extends UnitSuite {

  test("Solving 1 by 1 field with one mine should return the same thing") {
    val lines = Array("*")
    val field = MineField(lines)

    assertResult(field)(MineSolver(field))
  }

}