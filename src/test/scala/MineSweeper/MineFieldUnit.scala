package test.scala.MineSweeper

import test.scala.UnitSuite
import main.scala.MineSweeper.MineField

class MineFieldUnit extends UnitSuite {
  val lines = Array(". . .", ". * .", ". . .")
  val field = MineField(lines)

  test("Indexing position out side of the field returns None") {
    assertResult(None)(field(-1, -1))
    assertResult(None)(field(4, 4))
  }
}