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

  test("Solving 1 by 1 field without a mine should return zero") {
    val lines = Array(".")
    val field = MineField(lines)

    val lines1 = Array("0")
    val field1 = MineField(lines1)

    assertResult(field1)(MineSolver(field))
  }

  test("Solving 1 by 3 field with one mine in the middle should return '1 * 1'") {
    val field = MineField(Array(". * ."))
    val solution = MineField(Array("1 * 1"))
    assertResult(solution)(MineSolver(field))
  }
}