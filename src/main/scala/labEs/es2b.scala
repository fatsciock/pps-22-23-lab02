package labEs

object es2b extends App:

  println("Test predicate")

  val p1: Int => Int => Int => Boolean = x => y => z => x <= y && y == z
  val p2: (Int, Int, Int) => Boolean = (x, y, z) =>  x <= y && y == z
  def p3(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z
  def p4(x: Int, y: Int, z: Int): Boolean = x <= y && y == z

  println(p1(10)(15)(15))
  println(p2(10, 15, 15))
  println(p1(20)(15)(15))
  println(p2(20, 15, 15))

  println(p3(10)(15)(15))
  println(p4(10, 15, 15))
  println(p3(20)(15)(15))
  println(p4(20, 15, 15))

  println("Test compose")

  def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))

  println(compose(_ - 1, _ * 2)(5))

  def composeGen[X](f: X => X, g: X => X): X => X = x => f(g(x))


