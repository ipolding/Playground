// Add a case class Multiple tthat is a subclass of the Item class

abstract class Item
case class Article(description: String, price: Double) extends Item
case class Bundle(description: String, discount: Double, items: Item*) extends Item
case class Multiple(quantity: Int, item: Item) extends Item


object calc {
	def price(it: Item): Double = it match {
		case Article(_, p) => p
		case Bundle(_, discount, items @ _*) => items.map(price _).sum - discount
		case Multiple(qty, it @ _) => price(it) * qty
	} 
}

// Lists can be used to model trees
// Some of the list elements are numbers (leaves off of root)
// Others are lists (lists represent leaves attached to a node)
// Write a leafSum function to computer the sum of elements in the leaves
// Use Pattern Matching to differentiate between numbers and lists


object TreeSurgeon {

	def leafSum(treeList : List[Any]) : Int =  {
		var sum = 0
		for (x <- treeList) 	
			{x match {
				case x: Int => sum += x;
				case x: List[Int] => sum += leafSum(x); 
				case x: List[List[Int]] => sum += leafSum(x);
				}
			}
		sum
	}
}
