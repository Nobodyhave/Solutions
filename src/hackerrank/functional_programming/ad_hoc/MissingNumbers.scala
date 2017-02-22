package hackerrank.functional_programming.ad_hoc

import java.io.FileInputStream
import java.util.Scanner

/**
  * Created by Aleksandr on 21/02/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/missing-numbers-fp
  */
object MissingNumbers {
  def main(args: Array[String]) {
    //val in = new Scanner(System.in)
    val in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))

    val N = in.nextLine().toInt
    val A = in.nextLine()
      .split(" ")
      .map(_.toInt)

    val M = in.nextLine().toInt
    val B = in.nextLine()
      .split(" ")
      .map(_.toInt)

    println(B.diff(A).distinct.sorted.mkString(" "))
  }
}
