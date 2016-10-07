package cod.less.arrays

object OddOccurrencesInArray {

  def solution(arr: Array[Int]): Int = {
    val s = arr.sorted
    var n = 0
    for (x <- (0 until arr.length by 2)) {
      if (x < arr.length) {
        if (!(arr(x) == arr(x + 1)))
          n = arr(x)
      }
    }
    n
  }

  //functional way, with recursion
  def solution3a(arr: Array[Int]): Int = {

    def findOdd(a: List[Int], odd: Int): Int = {
      if (odd != Integer.MAX_VALUE) odd
      else if (a.length == 1) { a(0) }
      else {
        a match {
          case Nil                    => throw new Exception("Nill value passed")
          case head :: second :: tail => findOdd(tail, if (head != second) head else odd)
          case _                      => throw new Exception("Empty list")
        }
      }
    }
    if (arr.length == 1) arr(0)
    else
      findOdd(arr.sorted.toList, Integer.MAX_VALUE)
  }

}