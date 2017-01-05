package hackerrank.functional_programming.introduction

/**
  * Created by Aleksandr on 05/01/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/fp-list-replication
  */
object ListReplication {
  def f(num: Int, arr: List[Int]): List[Int] = {
    for (i <- 1 to num) println(arr.head)
    f(num, arr.tail)
  }
}
