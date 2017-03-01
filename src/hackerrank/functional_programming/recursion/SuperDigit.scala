package hackerrank.functional_programming.recursion

import java.io.FileInputStream
import java.util.Scanner

/**
  * Created by Aleksandr on 23/02/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/super-digit
  */
object SuperDigit {
  def main(args: Array[String]) {
    //val in = new Scanner(System.in)
    val in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))
    val N = in.next
    val K = in.nextInt

    val superN = calculateSuperDigit(N)
    println(calculateSuperDigit((superN * K).toString))
  }

  def calculateSuperDigit(digit: String): Int = {
    if (digit.length == 1) {
      return digit.head - '0'
    }

    calculateSuperDigit(digit.toCharArray.map(_ - '0').sum.toString)
  }
}
