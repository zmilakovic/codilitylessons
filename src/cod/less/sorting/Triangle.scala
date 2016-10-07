package cod.less.sorting

//** Solution scores 56% overall, as 0 performance
object Triangle {

  def main(args: Array[String]): Unit = {

    val a = Array(10, 2, 5, 1, 8, 20)
    println(solution(a))

  }

  def solution(a: Array[Int]): Int = {
    var res = 0
    val input = List.range(0, a.length)
    val comb = this.combinations1(3, input)
    for(i <- 0 until comb.length) {
      if(res == 0) {
        if(isTriangle(comb(i)(0), comb(i)(1), comb(i)(2), a)) {
          res = 1
        }
      }
    }
    res
  }

  //assume that a < b < c
  def isTriangle(p: Int, q: Int, r: Int, ar: Array[Int]): Boolean = {
    val A:Long = ar(p) + ar(q)
    val B:Long = ar(q) + ar(r)
    val C:Long = ar(r) + ar(p)
    val it =  A > ar(r) && B > ar(p) &&  C > ar(q)
    it
  }

  def combinations1[A](n: Int, ls: List[A]): List[List[A]] =
    if (n == 0) List(Nil)
    else flatMapSublists1(ls) { sl =>
      combinations1(n - 1, sl.tail) map { sl.head :: _ }
    }

  def flatMapSublists1[A, B](ls: List[A])(f: (List[A]) => List[B]): List[B] =
    ls match {
      case Nil                      => Nil
      case sublist @ (head :: tail) => f(sublist) ::: flatMapSublists1(tail)(f)
    }

}