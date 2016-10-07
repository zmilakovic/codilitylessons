package cod.less.iterations

object BinaryGap {

  //solution for BinaryGap problem 100% correctness
  def solution(n: Int): Int = {
    var s = n.toBinaryString.replace("0", " ").trim() //take care of leading/trailing zeros
    if (!s.contains(" ")) 0 //if no 0 in the string
    else s.split("1").foldLeft(0)((x, a) => if (x > a.length) x else a.length) //calculate largest gap
  }

}