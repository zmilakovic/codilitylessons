package cod.less.sorting

object MaxProductOfThree {

  def main(args: Array[String]): Unit = {

    
    //    val N = a.length
    //    val sort = a.sorted
    //    val r = sort(0) * sort(1) * sort(N - 1) max sort(N - 1) * sort(N - 2) * sort(N - 3)
    //    println(r)
    
    
    val a = Array(-3, 1, 2, -2, 5, 6)
    println(solution(a))

    //    var tempData = new ArrayBuffer[Int](0)
    //    var finArr = new ArrayBuffer[Array[Int]](0)
    //    getSubArrays(a, tempData, finArr, 2)
    //    finArr.foreach(x=>x.foreach(println))

    

    //    val r = ArrayBuffer[String]()
    //    combString("", "abcd", r)
    //    r.foreach(println)

    //    val r = Array(1, 2, 3)
    //    val res = combinations(r)
    //    res.toList.foreach(x => println(x.toList))

//    println(combinations(3, List(1, 2, 3, 4)))

  }

  def solution(a: Array[Int]): Int = {
    
    var result:Long = Long.MinValue
    val subArrays = combinations(3, a.toList)
    
    for(i <- 0 until subArrays.length) {
      val product = tripletProduct(subArrays(i))
      if(product > result) result = product
    }
    
    result.toInt
  }
  
  def tripletProduct(a:List[Int]):Long = {
    a(0) * a(1) * a(2)
  }

  def combinations[A](n: Int, ls: List[A]): List[List[A]] =
    if (n == 0) List(Nil)
    else flatMapSublists(ls) { sl =>
      combinations(n - 1, sl.tail) map { sl.head :: _ }
    }

  def flatMapSublists[A, B](ls: List[A])(f: (List[A]) => List[B]): List[B] =
    ls match {
      case Nil                   => Nil
      case sublist @ (head :: tail) => f(sublist) ::: flatMapSublists(tail)(f)
    }


  /**
  def combinations(a: Array[Int]): ArrayBuffer[Array[Int]] = {
    val res = ArrayBuffer(Array[Int]())
    combInt(Array(), a, res, -1)
    res
  }
  def combInt(head: Array[Int], tail: Array[Int], result: ArrayBuffer[Array[Int]], size: Int): ArrayBuffer[Array[Int]] = {
    val tempResult = ArrayBuffer(Array[Int]())
    if (size == -1 || head.length == size) {
      result ++= ArrayBuffer(head)
    }
    for (i <- 0 until tail.length)
      tempResult ++= combInt(head ++ Array(tail(i)), tail.slice(i + 1, tail.length), result, size)
    tempResult
  }

  def combString(head: String, tail: String, result: ArrayBuffer[String]): String = {
    var res = ""
    if (head.length() == 3)
      result += head
    for (i <- 0 until tail.length)
      res += combString(head + tail(i).toString, tail.slice(i + 1, tail.length), result)
    res
  }
  */
  


}