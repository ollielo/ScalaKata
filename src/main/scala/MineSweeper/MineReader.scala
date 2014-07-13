package main.scala.MineSweeper

import scala.io.Source

class MineField(val dims: Tuple2[Int, Int] = (0, 0)) {
  def this(lines: Array[String]) = {
    this((lines.length, lines(0).length))
  }
}

object MineField {
  def apply(lines: List[String]): MineField = {
    new MineField(lines.toArray)
  }
}

object MineReader {
  def mineFieldFactor(lines: List[String]): List[MineField] = {
    val dims = lines.head.split(" ").map(x => x.toInt)
    dims match {
      case Array(0, 0) => Nil
      case Array(nrows, ncols) =>
        val first = lines.tail.take(nrows)
        val rest = lines.tail.drop(nrows)
        MineField(first) :: mineFieldFactor(lines.tail.drop(nrows))
      case _ => Nil
    }
  }

  def apply(filename: String): Option[List[MineField]] = {
    val lines = Source.fromFile(filename).getLines.toList
    if (lines == Nil) {
      None
    } else {
      Some(mineFieldFactor(lines))
    }
  }
}