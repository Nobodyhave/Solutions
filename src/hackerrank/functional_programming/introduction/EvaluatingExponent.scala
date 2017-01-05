package hackerrank.functional_programming.introduction

/**
  * Created by Aleksandr on 05/01/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/eval-ex
  */
object EvaluatingExponent {
  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt()
    var a0: Int = 0
    while (a0 < n) {
      val x = sc.nextDouble()
      a0 += 1
      var result: Double = 0
      for (i <- 0 to 9) {
        result += Math.pow(x, i) / factorial(i)
      }
      println(result)
    }
  }

  def factorial(n: Int): Int = {
    if (n <= 1)
      1
    else
      n * factorial(n - 1)
  }
}
