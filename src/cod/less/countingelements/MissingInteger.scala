package cod.less.countingelements

object MissingInteger {

  def solution(a: Array[Int]): Int = {
    var minPosInt = 1
    if (a.length != 0) {
      val arr = a.sorted
      for (i <- 0 to arr.length - 1) {
        var curr = arr(i)
        if (curr > 0) {
          if (minPosInt < curr)
            return minPosInt
          else
            minPosInt = curr + 1
        }
      }
    }

    minPosInt
  }

}