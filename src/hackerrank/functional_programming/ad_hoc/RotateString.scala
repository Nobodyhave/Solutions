package hackerrank.functional_programming.ad_hoc

import scala.io.StdIn

/**
  * Created by Aleksandr on 05/01/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/rotate-string
  */
object RotateString {
  def main(args: Array[String]) {
    val N = StdIn.readInt()
    for (j <- 0 until N) {
      val S = StdIn.readLine()

      for (i <- 1 to S.length) {
        System.out.print(S.takeRight(S.length - i) + S.take(i) + " ")
      }
      System.out.println()
    }
  }
}
