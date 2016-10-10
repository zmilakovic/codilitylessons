package cod.less.prefixsums

import scala.util.Random
import scala.collection.mutable.ArrayBuffer

object GenomicRangeQuery {

  def p(s: String) = println(s)

  //implicit conversion
  implicit def int2String(i: Int): String = i.toString

  def main(args: Array[String]): Unit = {

    //    val v = Vector(4, 2, 1, 3, 4)
    //    val prefixSum = calcPrefixSum(v)
    //    println(prefixSum)
    //    val input = genRandomInput(10000000)
    //    println(solution(input, Array(21, 511, 0), Array(41, 5111, 6111)).toList)
    //    println("calc input done")
    //    val lst = input.map { char =>
    //      char match {
    //        case 'A' => 1
    //        case 'C' => 2
    //        case 'G' => 3
    //        case 'T' => 4
    //      }
    //    }
    //    println(s"lst done ${lst.length}")
    //    val pfSums = calcPrefixSumLst(lst.toList)
    //    println( (lst.scan(0)( (x,sum) => (x + sum))).length )
    //    println(calcPrefixSum(input).head)

    //    println(calcPrefixSum("CAGCCTA"))
    //    println(calcPrefixSum("AC"))

    //    val res = solution("CAGCCTA", Array(2, 5, 5), Array(4, 5, 6))
    //    println(res.toList)
    //    
    //    val res1 = solution("GGGGGGGGG", Array(2, 5, 0), Array(4, 5, 6))
    //    println(res1.toList)

    //    val res2 = solution("AC", Array(0, 0, 1), Array(0, 1, 1))
    //    val res3 = solution1("AC", Array(0, 0, 1), Array(0, 1, 1))
    //    println(res2.toList)
    //    println(res3.toList)
    val input = genRandomInput(1000000)
    println("input")
    val res4 = solution(input, Array(2, 4000, 50000), Array(40000, 5000, 60000))
    println(res4.toList)

  }
  
  def genRandomInput(length: Int): String = {
    val r = new ArrayBuffer[Char]
    for (i <- 0 to length) {
      val el = Random.nextInt(3) match {
        case 0 => 'A'
        case 1 => 'C'
        case 2 => 'G'
        case 3 => 'T'
      }
      r += el
    }
    r.mkString
  }

  /** Solution */
  import scala.collection.mutable.ArrayBuffer
  def solution(s: String, x: Array[Int], y: Array[Int]): Array[Int] = {
    val prefixSums = calcPrefixSum(s)
    val res = for {
      cnt <- 0 to x.length - 1
      (from, until) = (x(cnt), y(cnt))
    } yield {
      if (from == 0) {
        getMin(prefixSums(until))
      } else {
        val prefixSum = prefixSums(until) substract prefixSums(from - 1)
        getMin(prefixSum)
      }
    }

    res.toArray
  }

  def getMin(prefixSum: PrefixSums): Int = {
    var res = 0
    if (prefixSum.A != 0) return 1
    else if (prefixSum.C != 0) return 2
    else if (prefixSum.G != 0) return 3
    else if (prefixSum.T != 0) return 4
    prefixSum.intVal
  }

  case class PrefixSums(intVal: Int = 0, A: Int = 0, C: Int = 0, G: Int = 0, T: Int = 0) {
    /**
     * Substracts b from a. Value (intVal) will be kept from a object
     */
    def substract(b: PrefixSums): PrefixSums = {
      PrefixSums(this.intVal, this.A - b.A, this.C - b.C, this.G - b.G, this.T - b.T)
    }
  }
  def calcPrefixSum(s: String): Vector[PrefixSums] = {
    //call tail to skip the first dummy element
    val res = s.scanLeft((PrefixSums()))(getNextPrefixSum)
    res.tail.toVector
  }

  def getNextPrefixSum(previousVals: PrefixSums, char: Char): PrefixSums = {
    char match {
      case 'A' => PrefixSums(1, previousVals.A + 1, previousVals.C, previousVals.G, previousVals.T)
      case 'C' => PrefixSums(2, previousVals.A, previousVals.C + 1, previousVals.G, previousVals.T)
      case 'G' => PrefixSums(3, previousVals.A, previousVals.C, previousVals.G + 1, previousVals.T)
      case 'T' => PrefixSums(4, previousVals.A, previousVals.C, previousVals.G, previousVals.T + 1)
    }
  }
  /** End Solution */


  def solution1(S: String, P: Array[Int], Q: Array[Int]): Array[Int] = {

    val resp = for (ind <- 0 to P.length - 1) yield {
      val sub = S.substring(P(ind), Q(ind) + 1)
      var min = 4
      if (sub.contains("A")) (min = 1)
      else {
        if (sub.contains("C")) (min = 2)
        else {
          if (sub.contains("G")) (min = 3)
        }
      }
      min

    }

    return resp.toArray

  }

}