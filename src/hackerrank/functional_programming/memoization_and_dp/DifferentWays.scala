package hackerrank.functional_programming.memoization_and_dp

import java.io.FileInputStream
import java.math.BigInteger
import java.util.Scanner

/**
  * Created by Aleksandr on 20/02/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/different-ways-fp
  */
object DifferentWays {
  val FACTORIALS = factorials(1001)

  def main(args: Array[String]) {
    //val in = new Scanner(System.in)
    val in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))

    val N = in.nextInt()
    for (i <- 0 until N) {
      println(combinationsWithRepetitions(in.nextInt(), in.nextInt()))
    }
  }

  def combinationsWithRepetitions(N: Int, K: Int): BigInteger = {
    //val N = iN + K - 1
    FACTORIALS(N).divide(FACTORIALS(N - K)).divide(FACTORIALS(K))
  }

  def factorials(N: Int): Array[BigInteger] = {
    val nums = Array.fill(N + 1)(BigInteger.ZERO)
    nums.update(0, BigInteger.ONE)
    nums.update(1, BigInteger.ONE)

    var fact = BigInteger.ONE
    for (i <- 2 to N) {
      fact = fact.multiply(BigInteger.valueOf(i))
      nums.update(i, fact)
    }

    nums
  }
}
