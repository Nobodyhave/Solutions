package hackerrank.functional_programming.functional_structures

import java.io.FileInputStream
import java.util.Scanner

import scala.math.sqrt

/**
  * Created by Aleksandr on 01/03/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/prison-transport
  */
object PrisonTransport {
  def main(args: Array[String]) {
    //val in = new Scanner(System.in)
    val in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))

    val N = in.nextInt
    val M = in.nextInt

    val prisoners = new UnionFind(N + 1)
    for (m <- 0 until M) {
      prisoners.union(in.nextInt, in.nextInt)
    }

    for (i <- 1 to N) {
      if (prisoners.parent(i) != i) {
        prisoners.size.update(i, 0)
      }
    }

    println(prisoners.size.tail.map(it => sqrt(it).ceil.toInt).sum)
  }

  private class UnionFind(N: Int) {
    val parent = new Array[Int](N)
    val size = new Array[Int](N)
    var count = N

    var i: Int = 0
    while (i < N) {
      {
        parent(i) = i
        size(i) = 1
      }
      i += 1
    }

    def find(child: Int): Int = {
      var p = child
      while (p != parent(p)) {
        p = parent(p)
      }

      p
    }

    def connected(p: Int, q: Int): Boolean = {
      find(p) == find(q)
    }

    def union(p: Int, q: Int) {
      val rootP: Int = find(p)
      val rootQ: Int = find(q)
      if (rootP == rootQ) return
      if (size(rootP) < size(rootQ)) {
        parent(rootP) = rootQ
        size(rootQ) += size(rootP)
      }
      else {
        parent(rootQ) = rootP
        size(rootP) += size(rootQ)
      }
      count -= 1
    }
  }
}
