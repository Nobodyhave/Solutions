package hackerrank.functional_programming.recursion

import java.io.FileInputStream
import java.util.Scanner

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Aleksandr on 20/02/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/filter-elements
  */
object FilterElements {
  def main(args: Array[String]) {
    //val in = new Scanner(System.in)
    val in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))

    val T = in.nextInt()
    for (t <- 0 until T) {
      val N = in.nextInt()
      val K = in.nextInt()
      var array = ArrayBuffer[Int]()
      for (i <- 0 until N) {
        array = array :+ in.nextInt()
      }

      val a = array
        .zipWithIndex
        .groupBy(_._1)
        .values
        .filter(_.length >= K)
        .map(_.minBy(_._2))
        .toArray
        .sortBy(_._2)

      if (a.isEmpty) {
        print("-1")
      } else {
        a.foreach(it => print(it._1 + " "))
      }
      println
    }
  }
}
