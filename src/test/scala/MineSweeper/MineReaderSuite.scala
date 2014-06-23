package test.scala.MineSweeper

import test.scala.UnitSuite
import org.scalatest.BeforeAndAfter

class MineReaderSuite extends UnitSuite with BeforeAndAfter {
  test("Reading an empty file return Nothing") {
    assertResult(Nothing)(MineReader("minesweeper_empty.txt"))
  }
}