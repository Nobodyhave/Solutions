package hackerrank.functional_programming.functional_structures

import java.io.FileInputStream
import java.util.Scanner

import scala.collection.mutable.ListBuffer

/**
  * Created by Aleksandr on 02/03/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/john-and-fences
  */
object JohnAndFences {
  def main(args: Array[String]) {
    //val in = new Scanner(System.in)
    val in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))

    val N = in.nextLine.toInt
    val heights = in.nextLine.split(" ").map(_.toInt).array
    val stack = new ListBuffer[Int]

    var maxArea = 0
    var i = 0
    while (i < heights.length) {
      if (stack.isEmpty || heights(i) >= heights(stack.last)) {
        stack += i
        i += 1
      }
      else {
        val ind = stack.remove(stack.size - 1)
        val h = heights(ind)
        val w = if (stack.isEmpty) i else i - stack.last - 1
        val area = h * w
        if (area > maxArea) maxArea = area
      }
    }

    while (stack.nonEmpty) {
      val ind = stack.remove(stack.size - 1)
      val h = heights(ind)
      val w = if (stack.isEmpty) i else i - stack.last - 1
      val area = h * w
      if (area > maxArea) maxArea = area
    }

    println(maxArea)
  }
}
