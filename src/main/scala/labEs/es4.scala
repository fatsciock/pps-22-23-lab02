package labEs

object es4 extends App:

  case class Point2D(x: Double, y: Double)

  enum Shape:
    case Rectangle(base: Double, height: Double, origin: Point2D)
    case Circle(radius: Double, origin: Point2D)
    case Square(side: Double, origin: Point2D)

  def perimeter(shape: Shape): Double = shape match
    case Shape.Rectangle(b, h, _) => 2 * b + 2 * h
    case Shape.Circle(r, _) => 2 * 3.14 * r
    case Shape.Square(s, _) => s * 4

  def contains(shape: Shape, point: Point2D): Boolean =
    def compare(point: Point2D, origin: Point2D, v1: Double, v2: Double): Boolean =
      point.x >= origin.x && point.x <= (origin.x + v1) &&  point.y >= origin.y && point.y <= (origin.y + v2)

    println(perimeter(shape))
    shape match
      case Shape.Rectangle(b, h, origin) => compare(point, origin, b, h)
      case Shape.Circle(r, origin) => Math.sqrt(Math.pow(origin.x - point.x,2) + Math.pow(origin.y - point.y,2)) <= r
      case Shape.Square(s, origin) => compare(point, origin, s, s)

  val rect = Shape.Rectangle(10, 5, Point2D(0, 0))
  val circle = Shape.Circle(10, Point2D(0, 0))
  val square = Shape.Square(10, Point2D(0, 0))

  println(perimeter(rect))
  println(perimeter(circle))
  println(perimeter(square))

  println(contains(rect, Point2D(5, 5)))
  println(contains(circle, Point2D(11, 0)))
  println(contains(square, Point2D(5, 5)))