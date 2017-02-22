package hackerrank.functional_programming.memoization_and_dp

import java.util.Scanner

/**
  * Created by Aleksandr on 20/02/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/pentagonal-numbers
  */
object PentagonalNumbers {
  def main(args: Array[String]) {
    val in = new Scanner(System.in)

    val N = in.nextInt()
    for (i <- 0 until N) {
      val p = in.nextLong()
      println(p * (3 * p - 1) / 2)
    }
  }
}
