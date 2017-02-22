package hackerrank.functional_programming.functional_structures

import java.io.FileInputStream
import java.util.Scanner

import scala.collection.immutable.IntMap
import scala.math.min

/**
  * Created by Aleksandr on 20/02/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/lists-and-gcd
  */
object ListsAndGcd {
  def main(args: Array[String]) {
    //val in = new Scanner(System.in)
    val in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))

    val N = in.nextLine().toInt
    var num: IntMap[Int] = in.nextLine()
      .split(" ")
      .sliding(2, 2)
      .filter(it => it.head.nonEmpty && it.last.nonEmpty)
      .map(it => (it.head.toInt, it.last.toInt))
      .toMap.
      foldLeft(IntMap.empty[Int])((m, p) => m.updated(p._1.toInt, p._2))
    for (i <- 1 until N) {
      val num2: IntMap[Int] = in.nextLine()
        .split(" ")
        .sliding(2, 2)
        .map(it => (it.head.toInt, it.last.toInt))
        .toMap
        .foldLeft(IntMap.empty[Int])((m, p) => m.updated(p._1.toInt, p._2))

      num = num.intersectionWith(num2, (_, av, bv: Int) => min(av, bv))
    }

    num.foreach(it => print(it._1 + " " + it._2 + " "))
  }
}
