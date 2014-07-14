package main.scala.MineSweeper

object MineSolver {
  private def countMines(field: MineField, row: Int, col: Int): Char = {
    val zerosOnes = for {
      i <- -1 to 1
      j <- -1 to 1
    } yield {
      field(row + i, col + j) match {
        case Some('*') => 1
        case _         => 0
      }
    }
    zerosOnes.reduce(_ + _).toString().charAt(0)
  }

  def apply(field: MineField): MineField = {
    val array = Array() ++ (for {
      row <- 0 until field.dims._1
      col <- 0 until field.dims._2
    } yield {
      field(row, col) match {
        case Some('*') => '*'
        case _         => countMines(field, row, col)
      }
    })

    val aoa = array.sliding(field.dims._2).toArray

    MineField(aoa)
  }
}