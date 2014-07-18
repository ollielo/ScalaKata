package main.scala.GameOfLife

import scala.io.Source

class GoF(lines: Array[String]) {
  private val contents: Array[Array[Char]] =
    lines.map(line => line.split(" ").flatMap(x => x.toCharArray))

  val dims = (contents(0).length(), contents.length)

  def apply(x: Int, y: Int): Option[Char] = {
    if (x < 0 || x > dims._1 ||
      y < 0 || y > dims._2) {
      None
    } else {
      Some(contents(y)(x))
    }
  }

  override def equals(other: Any) = {
    other match {
      case that: main.scala.GameOfLife.GoF =>
        that.isInstanceOf[GoF] &&
          that.contents.deep == this.contents.deep
      case _ => false
    }
  }
}

object GoF {
  def apply(lines: Array[String]): GoF = {
    new GoF(lines)
  }
}

object Simulate {
  def apply(gof: GoF): GoF = {
    gof
  }
}

object GoFReader {
  def ParseGoF(lines: Array[String]): Option[GoF] = {
    // Array(xdims, ydims)
    val dims = lines(0).split(" ").map(x => x.toInt)
    dims match {
      case Array(0, 0) => None
      // ToDo: how to pattern match with ranges?
      case _           => Some(GoF(lines.tail))
    }
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