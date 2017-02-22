package hackerrank.functional_programming.introduction

import java.util.Scanner

import scala.collection.mutable

/**
  * Created by Aleksandr on 17/02/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/lambda-march-compute-the-area-of-a-polygon
  */
object ComputeAreaOfPolygon {
  def main(args: Array[String]) {
    val in = new Scanner(System.in)
    val N = in.nextInt()

    val points = new scala.collection.mutable.MutableList[(Int, Int)]
    for (n <- 0 until N) {
      points += ((in.nextInt(), in.nextInt()))
    }

    points += points.head

    println(area(points))
  }

  def area(A: mutable.MutableList[(Int, Int)]): Double = {
    if (A.length >= 2) {
      (A.head._1 * A(1)._2 - A.head._2 * A(1)._1) + area(A.drop(1))
    } else {
      0
    }
  }
}
