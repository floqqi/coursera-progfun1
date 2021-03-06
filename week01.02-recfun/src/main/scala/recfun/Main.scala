package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def f(chars: List[Char], open: Int): Boolean = {
      if (chars.isEmpty) {
        open == 0
      } else {
        val h = chars.head
        val n =
          if (h == '(') open + 1
          else if (h == ')') open - 1
          else open
        if (n >= 0) f(chars.tail, n)
        else false
      }
    }

    f(chars, 0)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    def count(m: Int, c: List[Int]): Int = {
      if (c.isEmpty) 0
      else if (m - c.head == 0) 1
      else if (m - c.head < 0) 0
      else countChange(m - c.head, c) + countChange(m, c.tail)
    }
    count(money, coins.sorted)
  }
}
