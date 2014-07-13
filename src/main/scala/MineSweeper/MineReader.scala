package main.scala.MineSweeper

import scala.io.Source

object MineReader {
  private def ParseMineFields(lines: Array[String]): List[MineField] = {
    val dims = lines.head.split(" ").map(x => x.toInt)
    dims match {
      case Array(0, 0) => Nil // (0, 0) means the end of the input stream.
      case Array(nrows, ncols) =>
        val (first, rest) = lines.tail.splitAt(nrows)
        MineField(first) :: ParseMineFields(rest)
      case _ => Nil // illegal input, terminate the parser
    }
  }

  def apply(filename: String): Option[List[MineField]] = {
    val lines = Source.fromFile(filename).getLines.toArray
    if (lines.isEmpty) {
      None
    } else {
      Some(ParseMineFields(lines))
    }
  }
}