package hackerrank.functional_programming.ad_hoc

import java.io.FileInputStream
import java.util.Scanner

import scala.math.min

/**
  * Created by Aleksandr on 21/02/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/common-divisors
  */
object CommonDivisors {
  def main(args: Array[String]) {
    //val in = new Scanner(System.in)
    val in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))

    val T = in.nextInt()
    for (t <- 0 until T) {
      val L = in.nextInt()
      val M = in.nextInt()

      var count = 0
      for (divisor <- 1 to min(L, M)) {
        if (L % divisor == 0 && M % divisor == 0) {
          count += 1
        }
      }

      println(count)
    }
  }
}
