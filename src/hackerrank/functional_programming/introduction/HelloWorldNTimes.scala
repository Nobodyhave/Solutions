package hackerrank.functional_programming.introduction

/**
  * Created by Aleksandr on 05/01/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/fp-hello-world-n-times
  */
object HelloWorldNTimes {
  def f(n: Int) = {
    for (i <- 1 to n) {
      println("Hello World")
    }
  }
}
