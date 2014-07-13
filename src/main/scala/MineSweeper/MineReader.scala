package main.scala.MineSweeper

import scala.io.Source

class MineField(val dims: Tuple2[Int, Int] = (0, 0)) {
  def this(lines: Array[String]) = {
    this((lines.length, lines(0).length))
  }

  def apply(row: Int, col: Int): Some[Char] = {
    Some(' ')
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
  def ParseMineFields(lines: Array[String]): List[MineField] = {
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