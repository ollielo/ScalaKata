package main.scala.MineSweeper

import scala.io.Source

class MineField {
  val dims = (0, 0)
}

object MineReader {
  def apply(filename: String): Option[List[MineField]] = {
    val lines = Source.fromFile(filename).getLines.toList
    if (lines == Nil) {
      None
    } else {
      Some(Nil)
    }
  }
}