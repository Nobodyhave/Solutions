package hackerrank.functional_programming.recursion

import java.util.Scanner

/**
  * Created by Aleksandr on 17/02/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/string-compression
  */
object StringCompression {
  def main(args: Array[String]) {
    val in = new Scanner(System.in)
    val s = in.next()

    val sb = new StringBuilder()
    sb.append(s.charAt(0))
    goDeeper(sb, s.toList.drop(1), 1)

    println(sb.toString())
  }

  def goDeeper(sb: StringBuilder, list: List[Char], count: Int): Unit = {
    if(list.isEmpty) {
      if(count > 1) {
        sb.append(count)
      }
      return
    }

    if(sb.last == list.head) {
      goDeeper(sb, list.drop(1), count + 1)
    } else {
      if(count > 1) {
        sb.append(count)
      }
      goDeeper(sb.append(list.head), list.drop(1), 1)
    }
  }
}
