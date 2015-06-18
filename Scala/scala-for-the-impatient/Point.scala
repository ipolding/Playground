/*4. Define a Point class with a companion object so that you can construct Point
instances as Point(3, 4) , without using new .*/

class Point(var x: Int, var y: Int) {
	

	
}

object Point {

	def apply(x: Int, y: Int) = new Point(x, y)

}