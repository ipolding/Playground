/* Define an abstract class Item with methods price and description . A SimpleItem is
an item whose price and description are specified in the constructor. Take
advantage of the fact that a val can override a def . A Bundle is an item that
contains other items. Its price is the sum of the prices in the bundle. Also
provide a mechanism for adding items to the bundle and a suitable description
method. */

import scala.collection.mutable.ArrayBuffer


abstract class Item {

    def price : Double

    def description : String 

}

class SimpleItem(override val price: Double, override val description: String) extends Item {
    
}

class Bundle extends Item {
    
    private val items : ArrayBuffer[Item] = new ArrayBuffer()

    def addItem(item: Item) {
        items += item
    }

    override def description : String = {
        var sb = new StringBuilder()
        var x = for (item <- items) {
            sb.append(item.description)
        }

        sb.toString                
    }

    override def price() : Double = {
        val sum : Double = (for (item <- items) yield item.price).sum
        sum
        }
    }