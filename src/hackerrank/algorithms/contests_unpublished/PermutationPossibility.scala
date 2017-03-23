package hackerrank.algorithms.contests_unpublished

import java.util.Scanner

/**
  * Created by Aleksandr on 22/03/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/contests/101hack47/challenges/permutation-possibility
  */
object PermutationPossibility {
  def main(args: Array[String]) {
    val sc = new Scanner(System.in)
    val m = sc.nextInt()
    val s = new Array[Int](m)
    for (s_i <- 0 until m) {
      s(s_i) = sc.nextInt()
    }
    if (s.distinct.length == m) {
      println("YES")
    } else {
      println("NO")
    }
  }
}
