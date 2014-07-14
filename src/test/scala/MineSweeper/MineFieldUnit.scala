package test.scala.MineSweeper

import test.scala.UnitSuite
import main.scala.MineSweeper.MineField

class MineFieldUnit extends UnitSuite {

  test("Two overloaded MineField factory return the same value") {
    val strings = Array(". * .", ". . .", ". . .")
    val arrays = Array(Array('.', '*', '.'), Array('.', '.', '.'),
      Array('.', '.', '.'))

    assert(MineField(strings) == MineField(arrays))
  }

  test("Indexing position out side of the field returns None") {
    val lines = Array(". . .", ". * .", ". . .")
    val field = MineField(lines)

    assertResult(None)(field(-1, -1))
    assertResult(None)(field(4, 4))
  }

}