package hackerrank.functional_programming.memoization_and_dp

import java.io.FileInputStream
import java.math.BigInteger
import java.util.Scanner

/**
  * Created by Aleksandr on 02/03/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/number-of-binary-search-tree
  */
object NumberOfBinarySearchTree {
  private val FACTORIALS = factorials(2000)
  private val CATALANS = catalans(1000)
  private val MOD = BigInteger.valueOf(100000007)

  def main(args: Array[String]) {
    //val in = new Scanner(System.in)
    val in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))

    val T = in.nextLine.toInt
    for (t <- 0 until T) {
      val N = in.nextLine.toInt

      println(CATALANS(N).mod(MOD))
    }
  }

  def catalans(N: Int): Array[BigInteger] = {
    val nums = new Array[BigInteger](N + 1)
    nums.update(0, BigInteger.ZERO)
    var i: Int = 1
    while (i <= N) {
      nums(i) = binomialCoefficient(2 * i, i).divide(BigInteger.valueOf(i + 1))
      i += 1
    }
    nums
  }

  def binomialCoefficient(N: Int, K: Int): BigInteger = {
    FACTORIALS(N).divide(FACTORIALS(N - K)).divide(FACTORIALS(K))
  }

  def factorials(N: Int): Array[BigInteger] = {
    val nums = new Array[BigInteger](N + 1)
    nums.update(0, BigInteger.ONE)
    nums.update(1, BigInteger.ONE)
    var fact = BigInteger.ONE
    var i = 2
    while (i <= N) {
      fact = fact.multiply(BigInteger.valueOf(i))
      nums.update(i, fact)
      i += 1
    }
    nums
  }
}
