package hackerrank.functional_programming.functional_structures

import java.io.FileInputStream
import java.util.Scanner

/**
  * Created by Aleksandr on 02/03/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/range-minimum-query
  */
object RangeMinimumQuery {
  def main(args: Array[String]) {
    //val in = new Scanner(System.in)
    val t1 = System.currentTimeMillis()
    val in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))
    val Array(n, m) = in.nextLine.split(" ").map(_.toInt)
    val a = in.nextLine.split(" ").map(_.toInt).array

    val tree = new SegmentTree(a)
    val sb = new StringBuilder
    for (i <- 0 until m) {
      //val Array(left, right) = in.nextLine.split(" ").map(_.toInt)
      val left = in.nextInt
      val right = in.nextInt
      sb.append(tree.rangeQuery(left, right)).append('\n')
    }
    println(sb.toString)
    val t2 = System.currentTimeMillis()
    //println("Time: " + (t2-t1))
  }

  private class SegmentTree(in: Array[Int]) {
    val input = in
    val segTreeSize = Math.pow(2, Math.ceil(Math.log(input.length) / Math.log(2)).toInt).toInt * 2 - 1
    val values = new Array[Int](segTreeSize)

    createSegmentTree(0, input.length - 1, 0)
    println()

    def createSegmentTree(low: Int, high: Int, present: Int) {
      if (low == high) {
        values.update(present, input(low))
      }
      else {
        val mid = (high + low) / 2
        createSegmentTree(low, mid, present * 2 + 1)
        createSegmentTree(mid + 1, high, present * 2 + 2)
        values.update(present, Math.min(values(present * 2 + 1), values(present * 2 + 2)))
      }
    }

    def rangeQuery(low: Int, high: Int): Int = {
      rangeQuery(0, input.length - 1, low, high, 0)
    }

    private def rangeQuery(low: Int, high: Int, qLow: Int, qHigh: Int, present: Int): Int = {
      if (qHigh < low || qLow > high) {
        return Integer.MAX_VALUE
      }

      if (low >= qLow && high <= qHigh) {
        return values(present)
      }
      val mid = (low + high) / 2
      Math.min(rangeQuery(low, mid, qLow, qHigh, present * 2 + 1), rangeQuery(mid + 1, high, qLow, qHigh, present * 2 + 2))
    }
  }
}
