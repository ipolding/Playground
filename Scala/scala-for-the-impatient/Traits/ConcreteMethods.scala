trait RectangleLike {

	def setFrame(x: Double, y : Double, w: Double, h: Double)

	def getX(): Double
	def getY(): Double
	def getHeight() : Double
	def getWidth() : Double

	def translate(dx: Int, dy: Int) {
		setFrame(getX() + dx, getY() + dy, getWidth(), getHeight())
	}

	def grow(h : Double, v : Double) {
		setFrame(getX(), getY(), h, v)
	}
}
