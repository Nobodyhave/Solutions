package hackerrank.functional_programming.ad_hoc

import java.io.FileInputStream
import java.util.Scanner

/**
  * Created by Aleksandr on 21/02/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/subset-sum
  */
object SubsetSum {
  def main(args: Array[String]) {
    //val in = new Scanner(System.in)
    val in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))

    val N = in.nextLine.toLong
    val prefixSum: Array[Long] = in.nextLine
      .split(" ")
      .map(_.toLong)
      .sortWith((l, r) => l > r)
      .scanLeft(0L)(_ + _)
      .tail

    val T = in.nextInt
    for (t <- 0 until T) {
      val S = in.nextLong

      val index = java.util.Arrays.binarySearch(prefixSum, S)

      if (index >= 0) {
        println(index + 1)
      } else {
        if (-(index + 1) + 1 <= N) {
          println(-(index + 1) + 1)
        } else {
          println(-1)
        }
      }
    }
  }
}
