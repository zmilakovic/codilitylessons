package cod.less.countingelements

object MaxCounters {

  def solution(n: Int, a: Array[Int]): Array[Int] = {

    var cnts: Array[Int] = Array.fill[Int](n)(0)
    var currMax = 0 //current max value, but not set
    var currMin = 0 //current actual value set by INCR_ALL operation
    val INCR_ALL = n + 1

    for (i <- 0 to a.length - 1) {
      val ops = a(i)
      if (ops == INCR_ALL) {
        currMin = currMax
      } else {
        if (cnts(ops - 1) <= currMin)
          cnts(ops - 1) = currMin + 1
        else
          cnts(ops - 1) = cnts(ops - 1) + 1

        if (cnts(ops - 1) > currMax)
          currMax = cnts(ops - 1) + 1
      }
    }

    //finally set all the counters which are below minimum to the minimum
    for (i <- 0 to cnts.length - 1) {
      if (cnts(i) < currMin)
        cnts(i) = currMin
    }
    cnts
  }

}