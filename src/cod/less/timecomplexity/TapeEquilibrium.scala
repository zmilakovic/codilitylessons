package cod.less.timecomplexity

object TapeEquilibrium {

  //error small elements!
  def solution(a: Array[Int]): Int = {

    @annotation.tailrec
    def findMinDiff(l: Array[Int], curr: Int, cnt: Int, sum1: Int, sum2: Int): Int = {
      //      println(s"$curr, $cnt, $sum1, $sum2")
      if (l.length == cnt + 1) curr
      else {
        val v = l(cnt)
        val dif = scala.math.abs((sum1 + v) - (sum2 - v))
        val currDiff = if (dif < curr) dif else curr
        findMinDiff(
          l,
          currDiff,
          cnt + 1,
          sum1 + v,
          sum2 - v)
      }
    }

    findMinDiff(a, Integer.MAX_VALUE, 0, 0, a.sum)
  }

  def solutionA(a: Array[Int]): Int = {
    //get the whole sum
    val allSum = a.sum

    //calculate left and right sum
    var sumLeft = a(0)
    var sumRight = allSum - sumLeft

    //set initial diff for P=1
    var minDiff = math.abs(sumLeft - sumRight) //difference

    // loop for all P after the initial P position
    for (p <- 1 to a.length - 2) {

      //recalculate values
      sumLeft += a(p)
      sumRight -= a(p)

      if (math.abs(sumLeft - sumRight) < minDiff) {
        // if difference is smaller then save new min diff
        minDiff = math.abs(sumLeft - sumRight)
      }

    }

    minDiff
  }

}