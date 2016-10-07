package cod.less.prefixsums

object PassingCars {

  def solution(n: Array[Int]): Int = {
    val max = 1e9
    //tuple (cars, cnt)
    val res = n.foldLeft(Tuple2[Int, Int](0, 0)) {
      (tuple, elem) =>
        if (elem == 0)
          (Tuple2(tuple._1 + 1, tuple._2))
        else {
          //set to -1 if > max, or already reached max before
          if (tuple._2 > max || tuple._2 == -1)
            (Tuple2(tuple._1, -1))
          else
            (Tuple2(tuple._1, tuple._2 + tuple._1))

        }
    }
    res._2
  }

}