package main.scala.GameOfLife

import scala.io.Source

class GoF

object GoFReader {
  def ParseGoF(lines: Array[String]): Option[GoF] = {
    None
  }

  def apply(filename: String): Option[GoF] = {
    val lines = Source.fromFile(filename).getLines.toArray;

    if (lines.isEmpty) {
      None
    } else {
      ParseGoF(lines)
    }
  }
}