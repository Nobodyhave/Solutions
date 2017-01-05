package hackerrank.functional_programming.recursion

import scala.io.StdIn

/**
  * Created by Aleksandr on 05/01/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/pascals-triangle
  */
object PascalsTriangle {
  def main(args: Array[String]) {
    val rowCount = StdIn.readInt()
    for (row <- 0 until rowCount) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  def pascal(c: Int, r: Int): Int = c match {
    case 0 => 1
    case c if c >=r => 1
    case _ => pascal(c-1,r-1)+pascal(c,r-1)
  }
}
