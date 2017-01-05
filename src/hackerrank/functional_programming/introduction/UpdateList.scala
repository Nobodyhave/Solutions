package hackerrank.functional_programming.introduction

/**
  * Created by Aleksandr on 05/01/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/fp-update-list
  */
object UpdateList {
  def f(arr: List[Int]): List[Int] = {
    arr.map(x => Math.abs(x))
  }
}
