package hackerrank.functional_programming.recursion

import scala.io.StdIn

/**
  * Created by Aleksandr on 05/01/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/functional-programming-warmups-in-recursion---fibonacci-numbers
  */
object FibonacciNumbers {
  def fibonacci(x: Int): Int = {
    if (x == 2 || x == 3) {
      return 1
    }
    fibonacci(x - 1) + fibonacci(x - 2)
  }

  def main(args: Array[String]) {
    println(fibonacci(StdIn.readInt()))
  }
}
