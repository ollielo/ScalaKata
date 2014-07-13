package test.scala.MineSweeper

import org.scalatest.BeforeAndAfterEach
import test.scala.UnitSuite
import main.scala.MineSweeper.MineReader

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
    val field = fields.head
    assertResult((4, 4))(field.dims)
  }

  test("The second field is 3 by 5") {
    val field = fields(1)
    assertResult((3, 5))(field.dims)
  }

}