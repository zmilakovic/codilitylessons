package cod.less.countingelements

object FrogRiverOne {

  def solution(x: Int, a: Array[Int]): Int = {
    var path: Set[Int] = Set()
    for (i <- 0 to a.length - 1) {
      path += a(i)
      if (path.size == x)
        return i
    }
    -1
  }

}