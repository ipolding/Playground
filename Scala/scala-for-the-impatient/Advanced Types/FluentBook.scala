/* 
Question 3:
Complete the fluent interface in Section 18.1, "Singleton Types", on page 246 so that one can call:
 
    book set Title to "Scala for the Impatient" set Author to "Cay Horstmann"
*/


/*
class Document {
    private var title : String
    private var author: String
 
	def setTitle(title: String): this.type = {this.title = title; this}
	def setAuthor(author: String): this.type = {this.author = author; this}

	def toString : String = this.title + " by " + this.author
}
*/
object Author
object Title
class Book {

    private var title : String = _ 
	private var author: String = _

    private var useNextArgAs : Any = null
    def set(obj: Title.type): this.type = { useNextArgAs = obj; this }
    def set(obj: Author.type): this.type = { useNextArgAs = obj; this }
    def to(arg: String) : this.type = { 
		if (useNextArgAs == Title) {
			this.title = arg; this
		} 
		else if (useNextArgAs == Author) {
                this.author = arg;
			    this 	
			}  else {
			    print("Bad argument")
			    this
			} 
		} 
   override def toString : String = this.title + " by " + this.author
}

import org.scalatest._

class FluentBookTest extends FlatSpec {

	"A book" should "have the title Scala for the Impatient and the author Cay Horstmann" in {
	val book = new Book

    book set Title to "Scala for the Impatient" set Author to "Cay Horstmann"
	
	assert(book.toString  == "Scala for the Impatient by Cay Horstmann")

}
}
