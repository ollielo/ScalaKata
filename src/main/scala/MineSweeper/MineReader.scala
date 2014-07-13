package main.scala.MineSweeper

import scala.io.Source

class MineField(lines: Array[String]) {
  private val contents: Array[Array[Char]] =
    lines.map(line => line.split(" ").flatMap(x => x.toCharArray))

  def dims = (contents.length, contents(0).length)

  def apply(row: Int, col: Int): Some[Char] = {
    Some(contents(row)(col))
  }

  override def toString() = {
    "Field: (" + dims._1 + ", " + dims._2
  }

}

object MineField {
  def apply(lines: Array[String]): MineField = {
    new MineField(lines)
  }
}

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