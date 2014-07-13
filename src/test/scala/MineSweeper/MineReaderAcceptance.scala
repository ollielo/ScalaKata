package test.scala.MineSweeper

import org.scalatest.BeforeAndAfterEach
import test.scala.UnitSuite
import main.scala.MineSweeper.MineReader

class MineReaderAcceptance extends UnitSuite with BeforeAndAfterEach {
  val dir = "src/test/resources/"
  val maybeFields = MineReader(dir + "minesweeper_acceptance.txt")

  test("Acceptance input has two MineFields") {
    maybeFields match {
      case Some(fields) =>
        assertResult(2)(fields.length)
      case None => fail("Expected Some(List[Field]), got None")
    }
  }

  test("The first filed in the accpetance input is 4 by 4") {
    maybeFields match {
      case Some(fields) =>
        val field = fields.head
        assertResult((4, 4))(field.dims)
      case None => fail("Expected Some(List[Field]), got None")
    }
  }

}