package cod.less.stacksqueues

object Brackets {

  def main(args: Array[String]): Unit = {

    println(solution("{[()()]}"))
//    println(solution("([)()]"))
//    println(solution("{{{{"))
//    println(solution("({{({}[]{})}}[]{})"))
//    println(solution("{[([}"))

    //    println('(' == '(')
  }

  
  def solution(s: String): Int = {
    if (isBalanced(s, "")) 1 else 0
  }

  def isBalanced(input: String, stack: String): Boolean = {
    println(s"curr char: ${if(input.length != 0) (input.charAt(0))}, restOfInput: ${if(input.length != 0) input.substring(1)}, stack: $stack")
    if (input.isEmpty()) {
      stack.isEmpty()
    } else if (isOpen(input.charAt(0))) {
      isBalanced(input.substring(1), input.charAt(0) + stack)
    } else if (isClose(input.charAt(0))) {
      !stack.isEmpty() && matchingBracket(stack.charAt(0), input.charAt(0)) && isBalanced(input.substring(1), stack.substring(1))
    } else (isBalanced(input.substring(1), stack))
  }

  val open = "{[("
  val close = "}])"
  def isOpen(c: Char) = open.indexOf(c) != -1
  def isClose(c: Char) = close.indexOf(c) != -1
  def matchingBracket(o: Char, c: Char) = open.indexOf(o) == close.indexOf(c)

}