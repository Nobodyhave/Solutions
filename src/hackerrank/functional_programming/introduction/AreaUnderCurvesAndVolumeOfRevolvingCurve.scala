package hackerrank.functional_programming.introduction

/**
  * Created by Aleksandr on 17/02/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/area-under-curves-and-volume-of-revolving-a-curv
  */
object AreaUnderCurvesAndVolumeOfRevolvingCurve {
  def f(coefficients: List[Int], powers: List[Int], x: Double): Double = {
    coefficients.zip(powers).map(t => element(t._1, t._2, x)).sum
  }

  def area(coefficients: List[Int], powers: List[Int], x: Double): Double = {
    val radius = coefficients.zip(powers).map(t => element(t._1, t._2, x)).sum

    Math.PI * Math.pow(radius, 2)
  }

  def summation(func: (List[Int], List[Int], Double) => Double, upperLimit: Int, lowerLimit: Int, coefficients: List[Int], powers: List[Int]): Double = {
    var sum = 0.0
    for (i <- lowerLimit * 1000 until upperLimit * 1000) {
      val step = 0.001
      sum = sum + func(coefficients, powers, i * step) * step
    }

    sum
  }

  val element = (c: Int, p: Int, x: Double) => {
    c * Math.pow(x, p)
  }
}
