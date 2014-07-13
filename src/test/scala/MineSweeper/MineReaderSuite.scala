package test.scala.MineSweeper

import test.scala.UnitSuite
import main.scala.MineSweeper.MineReader

class MineReaderSuite extends UnitSuite {
  test("Reading an empty file returns Nothing") {
    assertResult(None)(MineReader("minesweeper_empty.txt"))
  }

  test("Reading a input file with only 0 0 return an empty List") {
    assertResult(Some(Nil))(MineReader("minesweeper_0by0.txt"))
  }
}
