package hackerrank.functional_programming.introduction

/**
  * Created by Aleksandr on 05/01/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/fp-sum-of-odd-elements
  */
object SumOfOddElements {
  def f(arr: List[Int]): Int = {
    arr.filter(_ % 2 != 0).sum
  }
}
