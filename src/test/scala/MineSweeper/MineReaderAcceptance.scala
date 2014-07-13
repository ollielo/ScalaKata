package test.scala.MineSweeper

import org.scalatest.BeforeAndAfterEach

import main.scala.MineSweeper.MineReader
import test.scala.UnitSuite

class MineReaderAcceptance extends UnitSuite with BeforeAndAfterEach {
  val dir = "src/test/resources/"
  val maybeFields = MineReader(dir + "minesweeper_acceptance.txt")
  val fields = maybeFields match {
    case Some(fields) => fields
    case None         => fail("Expected Some(List[Field]), got None")
  }

  test("Acceptance input has two MineFields") {
    assertResult(2)(fields.length)
  }

  test("The first filed is 4 by 4") {
    val field = fields(0)
    assertResult((4, 4))(field.dims)
  }

  test("The second field is 3 by 5") {
    val field = fields(1)
    assertResult((3, 5))(field.dims)
  }

  test("The first field has mines at (0, 0) and (2, 1)") {
    val field = fields(0)
    assertResult(Some('*'))(field(0, 0))
    assertResult(Some('*'))(field(2, 1))
  }

  test("The second field has mines at (0, 0), (0, 1) and (2, 1)") {
    val field = fields(1)
    assertResult(Some('*'))(field(0, 0))
    assertResult(Some('*'))(field(0, 1))
    assertResult(Some('*'))(field(2, 1))
  }
}