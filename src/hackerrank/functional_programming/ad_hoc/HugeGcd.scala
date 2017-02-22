package hackerrank.functional_programming.ad_hoc

import java.io.FileInputStream
import java.util.Scanner

/**
  * Created by Aleksandr on 21/02/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/huge-gcd-fp
  */
object HugeGcd {
  def main(args: Array[String]) {
    //val in = new Scanner(System.in)
    val in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))

    val N = in.nextLine().toInt
    val A = in.nextLine()
      .split(" ")
      .map(_.toInt)
      .foldLeft(BigInt(1))((m, p) => m * p)

    val M = in.nextLine().toInt
    val B = in.nextLine()
      .split(" ")
      .map(_.toInt)
      .foldLeft(BigInt(1))((m, p) => m * p)

    if (A == 0 || B == 0) {
      println(1)
    } else {
      println(gcd(A, B) % 1000000007)
    }
  }

  def gcd(a: BigInt, b: BigInt): BigInt = {
    if (b == BigInt(0)) {
      return a
    }
    gcd(b, a % b)
  }
}
