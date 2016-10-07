package cod.less.timecomplexity

object PermMissingElem {

  def solution(a: Array[Int]): Int = {
    var previous = 0;
    if (a.length != 0) {
      val arr = a.sorted
      for (i <- arr) {
        previous = previous + 1
        if (previous != i) {
          return previous
        }
      }
    }
    return previous + 1
  }

}