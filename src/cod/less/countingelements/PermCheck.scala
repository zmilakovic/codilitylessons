package cod.less.countingelements

object PermCheck {

  def solution(a: Array[Int]): Int = {
    var expected = 0
    if (a.length == 0) return 0
    else {
      val arr = a.sorted
      for (i <- arr) {
        expected += 1
        if (expected != i)
          return 0
      }
    }

    1
  }

}