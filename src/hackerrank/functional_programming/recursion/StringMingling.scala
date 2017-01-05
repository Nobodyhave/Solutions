package hackerrank.functional_programming.recursion

import scala.io.StdIn

/**
  * Created by Aleksandr on 05/01/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/string-mingling
  */
object StringMingling {
  def main(args: Array[String]) {
    val P = StdIn.readLine()
    val Q = StdIn.readLine()

    printPQ(P, Q)
  }

  def printPQ(P: String, Q: String): Unit = {
    System.out.print(P.take(1) + Q.take(1))
    printPQ(P.tail, Q.tail)
  }
}
