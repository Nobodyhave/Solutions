package hackerrank.functional_programming.introduction

/**
  * Created by Aleksandr on 05/01/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/fp-filter-positions-in-a-list
  */
object FilterPositionInList {
  def f(arr: List[Int]): List[Int] = {
    arr.drop(1).sliding(1, 2).flatten.toList
  }
}
