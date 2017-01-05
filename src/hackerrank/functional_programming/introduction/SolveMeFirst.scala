package hackerrank.functional_programming.introduction

/**
  * Created by Aleksandr on 05/01/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/fp-solve-me-first
  */
object SolveMeFirst {
  def main(args: Array[String]) {
    println(io.Source.stdin.getLines().take(2).map(_.toInt).sum)
  }
}
