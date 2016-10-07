package cod.less.timecomplexity

object FrogJmp {

  def solution(x: Int, y: Int, d: Int): Int = {
    val i = (y - x) / d
    val m = (y - x) % d
    if (m > 0)
      i + 1
    else
      i
  }

}