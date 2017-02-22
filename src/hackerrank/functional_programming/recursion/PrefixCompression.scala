package hackerrank.functional_programming.recursion

import java.util.Scanner

/**
  * Created by Aleksandr on 17/02/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/prefix-compression
  */
object PrefixCompression {
  def main(args: Array[String]) {
    val in = new Scanner(System.in)
    val s1 = in.next()
    val s2 = in.next()

    findPrefix(new StringBuilder, s1, s2)
  }

  def findPrefix(sb: StringBuilder, s1: String, s2: String): Unit = {
    if (s1.isEmpty || s2.isEmpty || s1.head != s2.head) {
      println(sb.length + " " + sb.toString())
      println(s1.length + " " + s1)
      println(s2.length + " " + s2)

      return
    }

    findPrefix(sb.append(s1.head), s1.drop(1), s2.drop(1))
  }
}
