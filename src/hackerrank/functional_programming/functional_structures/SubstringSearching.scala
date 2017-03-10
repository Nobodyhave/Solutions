package hackerrank.functional_programming.functional_structures

import java.util.Scanner

/**
  * Created by Aleksandr on 01/03/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/kmp-fp
  */
object SubstringSearching {
  def main(args: Array[String]) {
    val in = new Scanner(System.in)

    val T = in.nextInt
    for (t <- 0 until T) {
      val text = in.next
      val pattern = in.next

      val dfa = new KMP(pattern)
      println(if (dfa.search(text) != text.length) "YES" else "NO")
    }
  }

  private class KMP(pat: String) {
    val M: Int = pat.length
    private val R: Int = 256
    private val dfa = Array.ofDim[Int](R, M)
    private var pattern: String = pat

    dfa(pat.charAt(0))(0) = 1
    var X: Int = 0
    var j: Int = 1

    while (j < M) {
      var c: Int = 0
      while (c < R) {
        dfa(c)(j) = dfa(c)(X)
        c += 1
      }
      dfa(pat.charAt(j))(j) = j + 1
      X = dfa(pat.charAt(j))(X)
      j += 1
    }

    def search(txt: String): Int = {
      val M: Int = pat.length
      val N: Int = txt.length
      var i: Int = 0
      var j: Int = 0
      i = 0
      j = 0
      while (i < N && j < M) {
        {
          j = dfa(txt.charAt(i))(j)
        }
        i += 1
      }

      if (j == M) return i - M
      N
    }
  }
}
