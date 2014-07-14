package main.scala.MineSweeper

class MineField(lines: Array[String]) {
  private val contents: Array[Array[Char]] =
    lines.map(line => line.split(" ").flatMap(x => x.toCharArray))

  def dims = (contents.length, contents(0).length)

  def apply(row: Int, col: Int): Option[Char] = {
    if (row >= 0 && row < dims._1 &&
      col >= 0 && col < dims._2) {
      Some(contents(row)(col))
    } else {
      None
    }
  }

  override def toString() = {
    contents map (line => line.mkString(" ")) mkString ("\n")
  }

  override def equals(other: Any) = {
    other match {
      case that: main.scala.MineSweeper.MineField =>
        that.isInstanceOf[MineField] &&
          that.contents.deep == this.contents.deep
      case _ => false
    }
  }
}

object MineField {
  def apply(lines: Array[String]): MineField = {
    new MineField(lines)
  }

  def apply(arrays: Array[Array[Char]]): MineField = {
    val lines = arrays.map(a => a.mkString(" "))
    MineField(lines)
  }
}
