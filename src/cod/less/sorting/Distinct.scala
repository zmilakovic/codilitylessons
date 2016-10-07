package codility.less.sorting

object Distinct {
  
  def main(args: Array[String]): Unit = {
    val a = Array(1, 2, 3, 2, -1,0,0,0)
    println(a.toSet.size)
  }
  
  def solution(a:Array[Int]):Int = {
    a.toSet.size
  }

}