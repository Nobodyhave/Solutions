package hackerrank.functional_programming.recursion

import java.util.Scanner

/**
  * Created by Aleksandr on 17/02/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/string-reductions
  */
object StringReductions {
  def main(args: Array[String]) {
    val in = new Scanner(System.in)
    val s = in.next()

    val sb = new StringBuilder

    removeDuplicates(sb, new Array[Boolean](26), s)

    println(sb.toString())
  }

  def removeDuplicates(sb: StringBuilder, marked: Array[Boolean], s: String): Unit = {
    if (s.isEmpty) {
      return
    }

    val index = s.head - 'a'
    if (!marked(index)) {
      marked(index) = true
      sb.append(s.head)
    }

    removeDuplicates(sb, marked, s.drop(1))
  }
}
