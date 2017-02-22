package hackerrank.functional_programming.introduction

import java.util.Scanner

/**
  * Created by Aleksandr on 17/02/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/functions-or-not
  */
object FunctionOrNot {

  def main(args: Array[String]) {
    val in = new Scanner(System.in)

    val T = in.nextInt()
    for (t <- 0 until T) {
      val N = in.nextInt()
      val map: scala.collection.mutable.Map[Int, Int] = scala.collection.mutable.Map()

      var isFunction = true
      for (n <- 0 until N) {
        val x = in.nextInt()
        val y: Int = in.nextInt()

        val num: Option[Int] = map.get(x)
        if (num.isEmpty) {
          map.put(x, y)
        } else {
          if (y != num.get) {
            isFunction = false
          }
        }
      }

      if (isFunction) {
        System.out.println("YES")
      } else {
        System.out.println("NO")
      }
    }
  }
}
