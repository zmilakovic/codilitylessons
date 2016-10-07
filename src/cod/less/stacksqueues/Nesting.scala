package cod.less.stacksqueues

object Nesting {
  
  def main(args: Array[String]): Unit = {
    
    val s = ")))((("   //"(()(())())"
    
    println(solution(")))((("))
    println(solution("(()(())())"))
    println(solution(""))
    
  }
  
  def solution(s: String): Int = {
    var res = -1
    if(s.length == 0) {
      res = 1
    } else {
      res = traverse(s)    
    }
    
    if(res == -1) throw new Exception("")
    res
  }
  
  def traverse(s:String):Int = {
    // -1 will indicate error and will stop counting
    val sum = s.foldLeft(0) {
      (sum, char) => {
        char match {
          //push
          case '(' => if(sum < 0) -1 else sum + 1
          //pull
          case ')' => if(sum < 0) -1 else sum - 1
        }
      }
    }
    if(sum == 0) 1 else 0
  }
  
}