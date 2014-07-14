package main.scala.MineSweeper

object MineSolver {
  def apply(field: MineField): MineField = {
    val arrays = (for {
      row <- 0 until field.dims._1
      col <- 0 until field.dims._2
    } yield {
      field(row, col) match {
        case Some('*') => '*'
        case _         => '0'
      }
    })

    //println(arrays)
    MineField(arrays.toArray.sliding(field.dims._1, field.dims._1).toArray)
    //field
  }
}