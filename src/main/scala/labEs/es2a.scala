package labEs

object es2a extends App:

  println("Test positive")

  val positive = (x: Int) => x match
    case x if x >= 0 => "positive"
    case _ => "negative"

  def positiveFun(x: Int): String = x match
    case x if x >= 0 => "positive"
    case _ => "negative"

  println(positive(5))
  println(positive(-1))

  println(positiveFun(5))
  println(positiveFun(-1))

  println("Test neg")

  def neg(f: String => Boolean): String => Boolean = !f(_)

  val empty: String => Boolean = _ == ""
  val notEmpty = neg(empty)
  println("Expected true - Res: " + notEmpty("foo"))
  println("Expected false - Res: " + notEmpty(""))
  val boolRes1 = notEmpty("foo") && !notEmpty("")
  println("Expected true - Res: " + boolRes1)

  def negGen[X](f: X => Boolean): X => Boolean = !f(_)

  val empty2: String => Boolean = _ == ""
  val notEmpty2 = neg(empty)
  println("Expected true - Res: " + notEmpty2("foo"))
  println("Expected false - Res: " + notEmpty2(""))
  val boolRes2 = notEmpty2("foo") && !notEmpty2("")
  println("Expected true - Res: " + boolRes2)

  val intPositive: Int => Boolean = _ >= 0
  val notIntPositive = negGen(intPositive)
  println("Expected false - Res: " + notIntPositive(5))
  println("Expected true - Res: " + notIntPositive(-1))
  println("Expected false - Res: " + notIntPositive(0))

