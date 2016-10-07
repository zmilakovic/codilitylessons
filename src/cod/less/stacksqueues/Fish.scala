package cod.less.stacksqueues



object Fish {

  def main(args: Array[String]): Unit = {

    //if a>b, get next from queue
    //if b<a, get next from array, increase cnt
    // sum cnt and remaining queue

    println(solution(Array(4, 3, 2, 1, 5), Array(0, 1, 0, 0, 0)))
    println(solution(Array(4, 3), Array(1, 0)))
    println(solution(Array(5, 3, 4), Array(1, 0, 0)))
    println(solution(Array(), Array()))

  }

  import scala.collection.mutable.Stack
  
  def solution(a: Array[Int], b: Array[Int]): Int = {
    
    //return survivors
    @annotation.tailrec
    def flow(index: Int, stack: Stack[Int], survivors:Int): Int = {
      //    println(s"$q, $index, $survivors")
      if (a.length == index) 
        stack.length + survivors
      else {
        //get next
        val next = a(index)
        // 1 - downstream, 0 - upstream 
        // 1 -> add to the stack, recurse
        if (b(index) == 1) {
          stack.push(next)
          flow(index + 1, stack, survivors)
        } else {
          // 1 -> check next against stack. If next > s.last, remove from stack. If stack is empty, add +1 to survivors.
          // If you face bigger in the stack, discard next and continue with next from the array.
          while (!stack.isEmpty && next > stack(0)) { stack.pop() } //"eat" as long as next > q.next
          if (stack.isEmpty)
            flow(index + 1, stack, survivors + 1)
          else
            flow(index + 1, stack, survivors)
        }
      }
    }
    
    //call function
    flow(0, new Stack[Int](), 0)
    
  }

  //return survivors
  //  def flow(a:Array[Int], direction:Array[Int], index:Int, survivors:Int, q:Queue[Int]):Int = {
  ////    println(s"$q, $index, $survivors")
  //    if(a.length == index) {
  ////      println(s"$survivors, ${q.length}")
  //      survivors + q.length //return survivors plus queue
  //    } else {
  //      //get next
  //      val next = a(index)
  //      // 0 - upstream, 1 - downstream
  //      // 1 -> add to the queue, recurse
  //      if(direction(index) == 1) {
  //        q.enqueue(next)
  //        flow(a, direction, index+1, survivors, q)
  //      } else {
  //          // 1 -> check next against queue. If next > q.last, remove from queue. If queue is empty, add +1 to survivors.
  //          // If you face bigger in the queue, discard next and continue with next from array.
  //        while(!q.isEmpty && next > q.front) { q.dequeue } //"eat" as long as next > q.next
  //        if(q.isEmpty) 
  //          flow(a, direction, index+1, survivors+1, q)
  //        else
  //          flow(a, direction, index+1, survivors, q)
  //      }
  //    }
  //  }

  //  def solution(a: Array[Int], b: Array[Int]): Int = {
  //    
  //  }

}