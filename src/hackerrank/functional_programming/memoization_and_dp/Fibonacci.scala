package hackerrank.functional_programming.memoization_and_dp

import java.io.FileInputStream
import java.util.Scanner

/**
  * Created by Aleksandr on 20/02/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/fibonacci-fp
  */
object Fibonacci {
  val fibonacci = Array.fill(10001)(0)

  def main(args: Array[String]) {
    //val in = new Scanner(System.in)
    val in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))

    calculateFibonacci()

    val N = in.nextInt()
    for (i <- 0 until N) {
      println(fibonacci(in.nextInt()))
    }
  }

  def calculateFibonacci(): Unit = {
    fibonacci.update(0, 0)
    fibonacci.update(1, 1)

    for (i <- 2 until fibonacci.length) {
      fibonacci.update(i, (fibonacci(i - 2) + fibonacci(i - 1)) % 100000007)
    }
  }
}
