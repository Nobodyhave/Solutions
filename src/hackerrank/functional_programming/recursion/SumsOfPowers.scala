package hackerrank.functional_programming.recursion

import java.io.FileInputStream
import java.util.Scanner

import scala.collection.mutable
import scala.math.pow

/**
  * Created by Aleksandr on 17/02/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/functional-programming-the-sums-of-powers
  */
object SumsOfPowers {
  var powers = mutable.MutableList[Int]()

  def fillPowersList(X: Int, N: Int): Unit = {
    var i = 1
    while (pow(i, N) <= X) {
      powers += pow(i, N).toInt
      i += 1
    }

    powers = powers.reverse
  }

  def numberOfWays(X: Int, previous: Int): Int = {
    if (X == 0) {
      return 1
    } else if (X < 0 || previous == 1) {
      return 0
    }

    var count = 0
    for (i <- powers) {
      if(i < previous) {
        count += numberOfWays(X - i, i)
      }
    }

    count
  }

  def main(args: Array[String]) {
    val in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))

    val X = in.nextInt()
    val N = in.nextInt()

    fillPowersList(X: Int, N: Int)

    if (X == 1) {
      println(1)
    } else {
      println(numberOfWays(X, powers.head + 1))
    }
  }

}
