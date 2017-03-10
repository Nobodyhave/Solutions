package hackerrank.functional_programming.memoization_and_dp

import java.io.FileInputStream
import java.util.Scanner

/**
  * Created by Aleksandr on 02/03/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/dice-path
  */
object DicePath {
  def main(args: Array[String]) {
    //val in = new Scanner(System.in)
    val in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))

    val T = in.nextInt
    var t = 0
    while (t < T) {
      //for (t <- 0 until T) {
      val M = in.nextInt
      val N = in.nextInt

      val board = Array.ofDim[State](M, N, 66)
      val initialState = new State(1, 6, 3, 4, 2, 5, 1)
      board(0)(0)(initialState.hash) = initialState

      for (i <- 1 until N) {
        val state = board(0)(i - 1).filter(_ != null).head.rotateRight()
        board(0)(i)(state.hash) = state
      }

      for (i <- 1 until M) {
        val state = board(i - 1)(0).filter(_ != null).head.rotateDown()
        board(i)(0)(state.hash) = state
      }

      for (i <- 1 until M) {
        for (j <- 1 until N) {
          val upStates = Array.ofDim[State](66)
          val leftStates = Array.ofDim[State](66)
          for (k <- 0 until 66) {
            if (board(i - 1)(j)(k) != null) {
              val upState = board(i - 1)(j)(k).rotateDown()
              upStates.update(upState.hash, upState)
            }
            if (board(i)(j - 1)(k) != null) {
              val leftState = board(i)(j - 1)(k).rotateRight()
              leftStates.update(leftState.hash, leftState)
            }
          }
          for (k <- 0 until 66) {
            board(i)(j)(k) = max(upStates(k), leftStates(k))
          }
        }
      }

      println(board(M - 1)(N - 1).filter(_ != null).maxBy(_.sum).sum)
      t += 1
    }
  }

  def max(s1: State, s2: State): State = {
    if (s1 == null && s2 == null) {
      null
    } else if (s1 == null) {
      s2
    } else if (s2 == null) {
      s1
    } else {
      if (s1.sum >= s2.sum) s1 else s2
    }
  }

  class State(val top: Int, val bottom: Int, val left: Int, val right: Int, val front: Int, val back: Int, val sum: Int) {
    val hash: Int = top * 10 + front

    def rotateDown(): State = {
      new State(back, front, left, right, top, bottom, sum + back)
    }

    def rotateRight(): State = {
      new State(left, right, bottom, top, front, back, sum + left)
    }
  }

}
