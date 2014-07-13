package main.scala.MineSweeper

import scala.io.Source

class MineField(val dims: Tuple2[Int, Int] = (0, 0)) {

}

object MineReader {
  def apply(filename: String): Option[List[MineField]] = {
    val lines = Source.fromFile(filename).getLines.toList
    if (lines == Nil) {
      None
    } else {
      val dims = lines.head.split(" ").map(x => x.toInt)
      dims match {
        case Array(0, 0)         => Some(Nil)
        case Array(nrows, ncols) => Some(List(new MineField((nrows, ncols))))
        case _                   => None
      }
    }
  }
}