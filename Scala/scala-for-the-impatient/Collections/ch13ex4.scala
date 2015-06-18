// Write a function that receives a collection of strings and a map from Strings to integers.
// Return a collection of Integers that are values of the map corresponding to one of the Strings in the collection.

// * hint* Use flatMap to combine the Option values returned by get

// e.g. Array("Tom", "Fred", "Harry") and Map ("Tom" -> 3,"Dick" -> 4, "Harry" -> 5)
// will return Array(3, 5)

object ch13ex4 {
    
    def findMapValue(strings: Iterable[String], valueMap: Map[String, Int]) : Array[Int] =  {
       val keysInMap = strings.filter(valueMap.contains) 
       val answer = for (key <- keysInMap) yield valueMap(key)
	answer.toArray    			
	}
    }
