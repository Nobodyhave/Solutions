package hackerrank.functional_programming.recursion

import java.io.FileInputStream
import java.util
import java.util.Scanner

import scala.collection.mutable.ListBuffer

/**
  * Created by Aleksandr on 23/02/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/lambda-march-concave-polygon
  */
object ConcavePolygon {
  def main(args: Array[String]) {
    //val in = new Scanner(System.in)
    val in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))

    val N = in.nextInt
    val points = new Array[Point](N)
    for (i <- 0 until N) {
      points.update(i, new Point(in.nextInt, in.nextInt))
    }

    println(if (grahamScan(points).size != N) "YES" else "NO")
  }

  def grahamScan(pointsInput: Array[Point]): ListBuffer[Point] = {
    val hull = new ListBuffer[Point]

    val N = pointsInput.length
    var points = pointsInput.sorted
    points.view(1, N).sortWith((q1, q2) => points.head.comparePolar(q1, q2)).copyToArray(points, 1)
    //util.Arrays.sort(points, 1, N, (q1, q2) => points.head.comparePolar(q1, q2))
    hull += points.head

    var k1: Int = 1
    while (k1 < N && (points(0) == points(k1))) {
      k1 += 1
    }
    if (k1 == N) hull

    var k2: Int = k1 + 1
    while (k2 < N && points(0) == points(k2) && points(k1) == points(k2)) {
      k2 += 1
    }
    hull += points(k2 - 1)

    for (i <- k2 until N) {
      var top = hull.remove(hull.size - 1)

      while (points.head.ccw(hull.last, top, points(i)) < 0) {
        top = hull.remove(hull.size - 1)
      }
      hull += top
      hull += points(i)
    }

    hull
  }

  class Point(val x: Int, val y: Int) extends Comparable[Point] {
    override def toString = s"Point($x, $y)"

    override def compareTo(that: Point): Int = {
      if (this.y < that.y) return -1
      if (this.y > that.y) return +1
      if (this.x < that.x) return -1
      if (this.x > that.x) return +1

      0
    }

    def ^(that: Point) =
      this.x * that.y - this.y * that.x

    def comparePolar(q1: Point, q2: Point): Boolean = {
      val dx1: Double = q1.x - x
      val dy1: Double = q1.y - y
      val dx2: Double = q2.x - x
      val dy2: Double = q2.y - y
      if (dy1 >= 0 && dy2 < 0) return true
      else if (dy2 >= 0 && dy1 < 0) return false
      else if (dy1 == 0 && dy2 == 0) {
        if (dx1 >= 0 && dx2 < 0) return true
        else if (dx2 >= 0 && dx1 < 0) return false
        else return dx1 < dx2
      }
      else return -ccw(Point.this, q1, q2) <= 0
    }

    def ccw(a: Point, b: Point, c: Point): Int = {
      val area2: Double = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x)
      if (area2 < 0) return -1
      else if (area2 > 0) return +1
      else return 0
    }
  }

}
