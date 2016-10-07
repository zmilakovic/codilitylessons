//package codility.sorting
//
//object NumberOfDiscIntersections {
//
//  def main(args: Array[String]): Unit = {
//
//    val a = Array[Int](1,5,2,1,4,0)
//    println( solution(a) )
//    
//    
//    
//    //    val v = Vector.fill(0, 100)(0)
//
//    //    println(fillChange(a, 3, 6).toList)
//    //    println(fillChange(a, 3, 6).toList)
//    //    println(fillChange(a, 3, 6).toList)
//
//  }
//
//  def solution(a: Array[Int]): Int = {
//
//    val maxRange = a.max
//    val cnts = new Array[Int](maxRange * 2 + a.length)
//
//    for (i <- 0 until a.length) {
//      val el = a(i)
//      val from = i - el + maxRange
//      val to = i + el + maxRange
//      fillChange(cnts, from, to)
//    }
//
//    println(cnts.toList)
//    //typle (sum, prevEl)
//    case class Counter(counter:Int = 0, previous:]Int = 0)
//    val res = cnts.foldLeft(Counter()) { (cnt, next) => if(cnt.previous != next) {println(s"$next, ${cnt.previous} ${Math.abs(cnt.previous-next)}"); Counter(cnt.counter+(Math.abs(cnt.previous-next)), next)} else {Counter(cnt.counter, next)} }
//    if(res.counter > 10000000) -1 else res.counter
//  }
//
//  def fillChange(a: Array[Int], from: Int, to: Int): Array[Int] = {
//    for (i <- from until to) {
//      a(i) = a(i) + 1
//    }
//    a
//  }
//
//}