object HigherOrder {

	def values(fun: (Int) => Int, low: Int, high: Int) {
		for (x <- low to high) {
			val res : Tuple2[Int, Int]  = (x, fun(x))
			print(res)
		}
	}

}
