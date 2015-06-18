abstract class Shape {
    def centerPoint : String
}

class Rectangle(val height : Double, val width : Double) extends Shape {
    override def centerPoint : String = {
        
        val center = "(" + height/2 + "," + width/2 + ")"
        center
    }
} 