package test.scala.MineSweeper

import org.scalatest.Suites
import org.scalatest.ParallelTestExecution

class MineSweeperSuites extends Suites(
  new MineFieldUnit,
  new MineReaderUnit,
  new MineReaderAcceptance,
  new MineSolverUnit,
  new MineSolverAcceptance) with ParallelTestExecution
