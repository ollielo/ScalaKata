package test.scala.MineSweeper

import test.scala.UnitSuite
import main.scala.MineSweeper.MineReader
import java.io.File
import org.scalatest.Ignore

class MineReaderSuite extends UnitSuite {
  val dir = "src/test/resources/"

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
    val maybeFields = MineReader(dir + "minesweeper_1by1_mine.txt")
    maybeFields match {
      case Some(fields) =>
        val field = fields.head
        assertResult((1, 1))(field.dims)
      case None => fail("Expected Some(List[Field]), got None")
    }
  }

  test("Reading an input file with only one mine returns a field with a mine at (0, 0)") {
    val maybeFields = MineReader(dir + "minesweeper_1by1_mine.txt")
    maybeFields match {
      case Some(fields) =>
        val field = fields.head
        assertResult(Some('*'))(field(0, 0))
      case None => fail("Expected Some(List[Field]), got None")
    }
  }

  test("Acceptance input has two MineFields") {
    val maybeFields = MineReader(dir + "minesweeper_acceptance.txt")
    maybeFields match {
      case Some(fields) =>
        assertResult(2)(fields.length)
      case None => fail("Expected Some(List[Field]), got None")
    }
  }

  test("The first filed in the accpetance input is 4 by 4") {
    val maybeFields = MineReader(dir + "minesweeper_acceptance.txt")
    maybeFields match {
      case Some(fields) =>
        val field = fields.head
        assertResult((4, 4))(field.dims)
      case None => fail("Expected Some(List[Field]), got None")
    }
  }
}
