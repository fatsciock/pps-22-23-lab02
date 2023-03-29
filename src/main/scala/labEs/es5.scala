package labEs

object es5 extends App:

  enum Option[A]:
    case Some(a: A)
    case None()

  object Option:

    def isEmpty[A](opt: Option[A]): Boolean = opt match
      case None() => true
      case _ => false

    def orElse[A, B >: A](opt: Option[A], orElse: B): B = opt match
      case Some(a) => a
      case _ => orElse

    def flatMap[A, B](opt: Option[A])(f: A => Option[B]): Option[B] = opt match
      case Some(a) => f(a)
      case _ => None()

    def filter[A](opt: Option[A])(f: A => Boolean): Option[A] = opt match
      case Some(a) if f(a) => opt
      case _ => None()

    def map[A](opt: Option[A])(f: A => Boolean): Option[Boolean] = opt match
      case Some(a) if f(a) => Some(true)
      case Some(_) => Some(false)
      case _ => None()

    def fold[A](opt: Option[A])(value: A)(f: A => A): A = opt match
      case Some(a) => f(a)
      case _ => value

  import Option.*
  import labEs.es5.Option
  import labEs.es5.Option.Some

  val s1: Option[Int] = Some(5)
  val s2: Option[Int] = Some(2)
  val s3: Option[Int] = None()

  println(filter(Some(5))(_ > 2)) // Some(5)
  println(filter(Some(5))(_ > 8)) // None
  println(filter(None[Int]())(_ > 2)) // None

  println(map(Some(5))(_ > 2)) // Some(true)
  println(map(Some(5))(_ > 8)) // Some(false)
  println(map(None[Int]())(_ > 2)) // None

  println(fold(Some(5))(1)(_ + 1)) // 6
  println(fold(None[Int]())(1)(_ + 1)) // 1
