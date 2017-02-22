package hackerrank.functional_programming.ad_hoc

import java.util.Scanner

/**
  * Created by Aleksandr on 20/02/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/remove-duplicates
  */
object RemoveDuplicates {
  def main(args: Array[String]) {
    val in = new Scanner(System.in)

    println(in.next().toList.distinct.mkString(""))
  }
}
