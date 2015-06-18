import java.awt.Point

class BOrderedPoint(x:Int = 0, y:Int = 0) extends Point(x, y) with scala.math.Ordered[Point] {
  override def compare(that: Point) = {
    if (x != that.x)
      x - that.x
    else
      y - that.y
  }
}

// val egg = new BOrderedPoint
// egg. setLocation(2,2)
// val bean = new BOrderedPoint
//  bean.setLocation(1, 2)
// val sausage = new BOrderedPoint
//  sausage.setLocation(1,1)
// val breakfast = Array(egg, sausage, bean)
// scala.util.Sorting.quickSort(breakfast)