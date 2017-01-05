package hackerrank.functional_programming.introduction

/**
  * Created by Aleksandr on 05/01/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/fp-list-length
  */
object ListLength {
  def f(arr: List[Int]): Int = {
    var count: Int = 0
    arr.foreach { x => count = count + 1 }
    count
  }
}
