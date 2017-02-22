package hackerrank.functional_programming.recursion

import java.io.FileInputStream
import java.util.Scanner

import scala.math.abs
import scala.util.control.Breaks._

/**
  * Created by Aleksandr on 20/02/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/sequence-full-of-colors
  */
object SequenceFullOfColors {
  def main(args: Array[String]) {
    //val in = new Scanner(System.in)
    val in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))
    val T = in.nextInt()
    for (i <- 0 until T) {
      val s = in.next()

      val colors = new Array[Int](4)
      var isFull = true

      breakable {
        for (i <- 0 until s.length) {
          val index = s.charAt(i) match {
            case 'R' => 0
            case 'G' => 1
            case 'Y' => 2
            case 'B' => 3
          }
          colors(index) = colors(index) + 1

          if (abs(colors(0) - colors(1)) > 1) {
            isFull = false
            break
          } else if (abs(colors(2) - colors(3)) > 1) {
            isFull = false
            break
          }
        }
      }

      isFull = colors(0) == colors(1) && colors(2) == colors(3)

      println(if (isFull) "True" else "False")
    }
  }
}
