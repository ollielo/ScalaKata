package test.scala.MineSweeper

import test.scala.UnitSuite
import main.scala.MineSweeper.MineSweeper

class MineSweeperSuite extends UnitSuite {
  ignore("0x0 field returns empty string") {
    assertResult("")("")
  }

  test("1x1 field with one mine should return itself") {
    val field = "*"
    assertResult("*")(MineSweeper(field))
  }
}
