package test.scala.MineSweeper

import test.scala.UnitSuite
import main.scala.MineSweeper.MineReader

class MineReaderSuite extends UnitSuite {
  test("Reading an empty file returns Nothing") {
    assertResult(None)(MineReader("minesweeper_empty.txt"))
  }
}
