package main.scala.MineSweeper

class MineField(lines: Array[String]) {
  private val contents: Array[Array[Char]] =
    lines.map(line => line.split(" ").flatMap(x => x.toCharArray))

  def dims = (contents.length, contents(0).length)

  def apply(row: Int, col: Int): Some[Char] = {
    Some(contents(row)(col))
  }

  override def toString() = {
    contents map (line => line.mkString(" ")) mkString ("\n")
  }

}

object MineField {
  def apply(lines: Array[String]): MineField = {
    new MineField(lines)
  }
}
