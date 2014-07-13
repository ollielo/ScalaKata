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
}
