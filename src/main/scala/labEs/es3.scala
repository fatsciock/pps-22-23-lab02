package labEs

import scala.annotation.tailrec

object es3 extends App:

  @tailrec
  def gcd(a: Int, b: Int): Int = a match
    case _ if a % b == 0 => b
    case _ if b > a => gcd(b, a)
    case _ if a > b => gcd(b, a % b)

  println(gcd(8, 12))
  println(gcd(14, 7))

