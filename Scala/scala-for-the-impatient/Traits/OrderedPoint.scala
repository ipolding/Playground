// Define a class OrderedPoint by mixing scala.math.Ordered[Point] into java.awt.Point

// Use lexicographic ordering i.e (x, y) < (x', y') if x < x' or x = x' and y < y' 

import java.awt.Point

class OrderedPoint extends Point with Ordered[Point] {

    def compare(that: Point) : Int = {  

            
            if (this.x == that.x) {
                return this.y - that.y
            } else {
                return this.x - that.x
            }
}

}

// val egg = new OrderedPoint
// egg. setLocation(2,2)
// val bean = new OrderedPoint
//  bean.setLocation(1, 2)
// val sausage = new OrderedPoint
//  sausage.setLocation(1,1)
// val breakfast = Array(egg, sausage, bean)
// scala.util.Sorting.quickSort(breakfast)

// i expect the array to be: sausage, bean egg