package cod.less.prefixsums

object CountDiv {
  
    def solution(a: Int, b: Int, k: Int): Int = {

    //    val arr = if (a == b) List(a) else List.range(a, b)
    //    val res = arr.foldLeft(0)((cnt, elem) => if (elem % k == 0) (cnt + 1) else cnt)
    //    res
    var res = b / k - a / k
    if (a % k == 0) res += 1
    res
  }
  
}