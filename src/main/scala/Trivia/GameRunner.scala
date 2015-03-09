package main.scala.Trivia

import java.util.Random

object GameRunner {
  var notAWinner = false

  def main(args: Array[String]) {
    var aGame = new Game();
    aGame.add("Chet")
    aGame.add("Pat")
    aGame.add("Sue")

    var rand: Random = new Random

    do {
      aGame.roll(rand.nextInt(5) + 1)
      if (rand.nextInt(9) == 7) {
        notAWinner = aGame.wrongAnswer
      } else {
        notAWinner = aGame.wasCorrectlyAnswered
      }
    } while (notAWinner)
  }
}