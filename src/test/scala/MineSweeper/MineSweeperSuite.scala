package test.scala.MineSweeper

import test.scala.UnitSuite

class MineSweeperSuite extends UnitSuite {
  test("1x1 field with one mine should return itself") {
    val field = "*"
    assertResult("*")(MineSweeper(field))
  }
}
