package test.scala.MineSweeper

import main.scala.MineSweeper.MineField
import main.scala.MineSweeper.MineReader
import test.scala.UnitSuite

class MineReaderUnit extends UnitSuite {
  val dir = "src/test/resources/"

  private def getMineField(filename: String): MineField = {
    val maybeFields = MineReader(dir + "minesweeper_1by1_mine.txt")
    maybeFields match {
      case Some(fields) => fields.head
      case None         => fail("Expected Some(List[Field]), got None")
    }
  }

  test("Reading an empty file returns None") {
    assertResult(None) {
      MineReader(dir + "minesweeper_empty.txt")
    }
  }

  test("Reading an input file with only 0 0 return an empty List") {
    assertResult(Some(Nil)) {
      MineReader(dir + "minesweeper_0by0_field.txt")
    }
  }

  test("Reading an input file with only one mine returns a List with a 1 by 1 field") {
    val field = getMineField("minesweeper_1by1_mine.txt")
    assertResult((1, 1))(field.dims)
  }

  test("Reading an input file with only one mine returns a field with a mine at (0, 0)") {
    val field = getMineField("minesweeper_1by1_mine.txt")
    assertResult(Some('*'))(field(0, 0))
  }
}

