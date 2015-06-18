// Implement a function that works just like mkString, using reduceLeft

object ch13ex5 {
	def newMkString(coll:Iterable[Any]){ 
		print(coll.map(_.toString).reduceLeft(_ + " " + _)	)
	}
}
