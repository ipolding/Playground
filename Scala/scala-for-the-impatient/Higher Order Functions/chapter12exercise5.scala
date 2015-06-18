// Write a function largest(fun: (Int) => Int, inputs: Seq[Int]) that yields the largest value of a function within a given sequence of inputs.

// For example, largest(x => 10 * x -x 8 x, 1 to 10) should return 25. 

// Do not use a loop or recursion


object Ch12Ex5 {
	
	def largest(fun: (Int) => Int, inputs: Seq[Int]) = {
		fun(inputs.maxBy(fun))
	}

}
