package main.scala.MineSweeper

object MineSweeper {
  def apply(filename: String): String = {
    val maybeFields = MineReader(filename)

    maybeFields match {
      case Some(fields) => (fields zip (1 to fields.length)).map {
        case (field, i) => {
          "Field #" + i + ":\n" +
            MineSolver(field).toString() +
            "\n\n"
        }
      }.reduce(_ + _)
      case _ => ""
    }
  }

  def main(args: Array[String]): Unit = {
    val sol = MineSweeper("src/test/resources/minesweeper_acceptance.txt")
    println(sol)
  }
}
