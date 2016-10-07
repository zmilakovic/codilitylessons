package cod.less.arrays

object CyclicRotation {

  //rotate an array to the right by K
  def solution(a: Array[Int], k: Int): Array[Int] = {
    if (k < 0 || k > 100) throw new Exception("wrong parameter K")
    if (a.length == 0 || a.length == 1) return a

    val newArray = a.clone()

    def flipArray(newAr: Array[Int], orig: Array[Int], cnt: Int, k: Int): Array[Int] = {
      if (cnt == newAr.length) newAr
      else {
        if (cnt >= k) {
          newAr(cnt) = orig(cnt - k)
        } else {
          newAr(cnt) = orig(orig.length - (k - cnt))
        }
        flipArray(newAr, orig, cnt + 1, k)
      }
    }

    flipArray(newArray, a, 0, k)
  }

}