package hackerrank.functional_programming.recursion

import scala.io.StdIn

/**
  * Created by Aleksandr on 05/01/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/functional-programming-warmups-in-recursion---gcd
  */
object ComputingGcd {
  def gcd(x: Int, y: Int): Int = {
    if (y == 0) {
      return x
    }
    gcd(y, x % y)
  }

  def acceptInputAndComputeGCD(pair: List[Int]) = {
    println(gcd(pair.head, pair.reverse.head))
  }

  def main(args: Array[String]) {
    acceptInputAndComputeGCD(StdIn.readLine().trim().split(" ").map(x => x.toInt).toList)
  }
}
