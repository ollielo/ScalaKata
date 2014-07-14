package main.scala.MineSweeper

object MineSolver {
  def apply(field: MineField): MineField = {
    val array = Array() ++ (for {
      row <- 0 until field.dims._1
      col <- 0 until field.dims._2
    } yield {
      field(row, col) match {
        case Some('*') => '*'
        case _         => '0'
      }
    })

    val aoa = array.sliding(field.dims._2).toArray

    MineField(aoa)
  }
}