// Using Pattern matching, write a function SWAP that receives a pair of integers and returns the pair with components swapped.

object ch14ex2 {

	def swapPair(pair: Pair[Int, Int]) : Pair[Int,Int] = {
 	    val result = pair match {
	        case (x, y) => Pair(y, x)	
		}
            result
	}
}

object ch14ex3 {
// swap the first two elements of an array with at least 2 elements
	def swapArray(arr: Array[Int]) : Array[Int] = {
 	    arr match {
		    case Array(x, y) => {arr(1)=x ; arr(0) = y}
		    case Array(x, y, _*) =>  {arr(1)=x ; arr(0) = y}
  	 	    case _ => print("no match")	
		}
		arr
            }
}
