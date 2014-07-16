package test.scala.MineSweeper

import test.scala.UnitSuite
import main.scala.MineSweeper.MineField
import main.scala.MineSweeper.MineSolver

class MineSolverAcceptance extends UnitSuite {

  test("Solving the first field in the acceptance test") {
    val input = MineField(Array(
      "* . . .",
      ". . . .",
      ". * . .",
      ". . . ."))

    val output = MineField(Array(
      "* 1 0 0",
      "2 2 1 0",
      "1 * 1 0",
      "1 1 1 0"))

    assertResult(output)(MineSolver(input))
  }

  test("Solving the second field in the acceptance test") {
    val input = MineField(Array(
      "* * . . .",
      ". . . . .",
      ". * . . ."))

    val output = MineField(Array(
      "* * 1 0 0",
      "3 3 2 0 0",
      "1 * 1 0 0"))

    assertResult(output)(MineSolver(input))
  }
}