package hackerrank.functional_programming.recursion

import java.io.FileInputStream
import java.util.Scanner

/**
  * Created by Aleksandr on 17/02/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/string-o-permute
  */
object StringPermute {
  def main(args: Array[String]) {
    //val in = new Scanner(System.in)
    val in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))
    val N = in.nextInt()

    for (n <- 0 until N) {
      val s = in.next()

      s.toList.sliding(2, 2).foreach(it => print(it(1).toString + it.head))
      println()
    }
  }
}
