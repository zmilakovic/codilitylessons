package cod.less.prefixsums

import scala.util.Random
import scala.collection.mutable.ArrayBuffer

object MinAvgTwoSlice {

  def main(args: Array[String]): Unit = {
    //    println(genRandomInput(20).toList)
    println(solution(Array(4, 2, 2, 5, 1, 5, 8)))
    println(solution(Array(5, 2, 1)))

    //    Array(1,2,3).slice(from, until)
  }

  def genRandomInput(length: Int): Array[Int] = {
    val r = new ArrayBuffer[Int]
    for (i <- 0 to length) {
      val el = Random.nextInt(10)
      r += el
    }
    r.toArray
  }

  /** Solution */
  def solution(a: Array[Int]): Int = {
    var minIndex = 0
    var minAvg:Double = Double.MaxValue

    for (i <- 0 to a.length - 2) {
      val avg2:Double = (a(i) + a(i + 1)) / 2d
      if (avg2 < minAvg) {
        minAvg = avg2
        minIndex = i
      }
      if (i != a.length - 2) {
        val avg3:Double = (a(i) + a(i + 1) + a(i + 2)) / 3d
        if (avg3 < minAvg) {
          minAvg = avg3
          minIndex = i
        }
      }
    }

    minIndex
  }

  
  /** Alternate Solution */
  def solution1(a: Array[Int]): Int = {

    (a.foldLeft[(Int, Option[Double], Int)]((0, None, -1)) { (t, item) =>
      val (index, min, results) = t

      val checkPair = index <= a.size - 2
      val checkTrio = index <= a.size - 3

      val pairMin = checkSlice(min, checkPair) { () => (a(index) + a(index + 1)) / 2.0 }
      val trioMin = checkSlice(min, checkTrio) { () => (a(index) + a(index + 1) + a(index + 2)) / 3.0 }

      if (pairMin.isDefined || trioMin.isDefined) (index + 1, Some(Math.min(pairMin.getOrElse(Double.MaxValue), trioMin.getOrElse(Double.MaxValue))), index)
      else (index + 1, min, results)
    })._3
  }

  def checkSlice(min: Option[Double], check: Boolean)(f: () => Double) = {
    check match {
      case true =>
        val value = f()
        min map { minValue =>
          if (value < minValue) Some(value)
          else None
        } getOrElse Some(value)

      case false =>
        None
    }
  }
}