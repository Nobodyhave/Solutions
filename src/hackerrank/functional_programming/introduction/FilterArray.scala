package hackerrank.functional_programming.introduction

/**
  * Created by Aleksandr on 05/01/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/fp-filter-array
  */
object FilterArray {
  def f(delim: Int, arr: List[Int]): List[Int] = {
    arr.filter(_ < delim)
  }
}
