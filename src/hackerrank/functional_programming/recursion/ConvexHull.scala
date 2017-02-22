package hackerrank.functional_programming.recursion

import java.io.FileInputStream
import java.util.Scanner

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * Created by Aleksandr on 21/02/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/convex-hull-fp
  */
object ConvexHull {
  def main(args: Array[String]) {
    //val in = new Scanner(System.in)
    val in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))

    val N = in.nextInt
    val points = new mutable.ListBuffer[Point]
    for (i <- 0 until N) {
      points += new Point(in.nextInt, in.nextInt)
    }
    val sortedPoints = quickHull(points).sorted
    sortedPoints += sortedPoints.head

    println(dist(sortedPoints))
  }

  def quickHull(points: mutable.ListBuffer[Point]): mutable.ListBuffer[Point] = {
    val convexHull = new mutable.ListBuffer[Point]()
    if (points.size < 3) {
      return points
    }

    var minPoint = -1
    var maxPoint = -1
    var minX = Integer.MAX_VALUE
    var maxX = Integer.MIN_VALUE
    for (i <- points.indices) {
      if (points(i).x < minX) {
        minX = points(i).x
        minPoint = i
      }
      if (points(i).x > maxX) {
        maxX = points(i).x
        maxPoint = i
      }
    }
    val A = points(minPoint)
    val B = points(maxPoint)
    convexHull += A
    convexHull += B
    points -= A
    points -= B

    val leftSet = new mutable.ListBuffer[Point]
    val rightSet = new mutable.ListBuffer[Point]

    for (i <- points.indices) {
      val p = points(i)
      if (pointLocation(A, B, p) == -1) {
        leftSet += p
      } else if (pointLocation(A, B, p) == 1) {
        rightSet += p
      }
    }
    hullSet(A, B, rightSet, convexHull)
    hullSet(B, A, leftSet, convexHull)

    convexHull
  }

  def hullSet(A: Point, B: Point, set: mutable.ListBuffer[Point], hull: mutable.ListBuffer[Point]): Unit = {
    val insertPosition = hull.indexOf(B)
    if (set.isEmpty) {
      return
    }
    if (set.size == 1) {
      val p = set.head
      set -= p
      hull.insert(insertPosition, p)
      return
    }
    var dist = Integer.MIN_VALUE
    var furthestPoint = -1
    for (i <- set.indices) {
      val p = set(i)
      val d = distance(A, B, p)
      if (d > dist) {
        dist = d
        furthestPoint = i
      }
    }
    val P = set(furthestPoint)
    set.remove(furthestPoint)
    hull.insert(insertPosition, P)

    // Determine who's to the left of AP
    val leftSetAP = new mutable.ListBuffer[Point]
    for (i <- set.indices) {
      val M = set(i)
      if (pointLocation(A, P, M) == 1) {
        leftSetAP += M
      }
    }

    // Determine who's to the left of PB
    val leftSetPB = new mutable.ListBuffer[Point]
    for (i <- set.indices) {
      val M = set(i)
      if (pointLocation(P, B, M) == 1) {
        leftSetPB += M
      }
    }
    hullSet(A, P, leftSetAP, hull)
    hullSet(P, B, leftSetPB, hull)

  }

  def dist(A: mutable.ListBuffer[Point]): Double = {
    if (A.length >= 2) {
      scala.math.sqrt(scala.math.pow(A.head.x - A(1).x, 2) + scala.math.pow(A.head.y - A(1).y, 2)) + dist(A.drop(1))
    } else {
      0
    }
  }

  def distance(A: Point, B: Point, C: Point): Int = {
    val ABx = B.x - A.x
    val ABy = B.y - A.y
    var num = ABx * (A.y - C.y) - ABy * (A.x - C.x)
    if (num < 0) {
      num = -num
    }
    num
  }

  def pointLocation(A: Point, B: Point, P: Point): Int = {
    val cp1 = (B.x - A.x) * (P.y - A.y) - (B.y - A.y) * (P.x - A.x)
    if (cp1 > 0)
      1
    else if (cp1 == 0)
      0
    else
      -1
  }

  class Point(val x: Int, val y: Int) extends Comparable[Point] {
    override def toString = s"Point($x, $y)"

    override def compareTo(o: Point): Int = {
      -1
    }

    def ^(that: Point) =
      this.x * that.y - this.y * that.x
  }

}
