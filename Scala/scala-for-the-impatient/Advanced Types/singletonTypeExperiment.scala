import scala.collection.mutable.ArrayBuffer

class Document {

	var title : String = ""
	var author: String = ""
	
	def setTitle(title: String) :this.type  = {this.title = title; this}
	def setAuthor(author: String) :this.type  = {this.author = author; this}

}

class Book extends Document {

	var chapters : ArrayBuffer[String] = new ArrayBuffer[String]

	def addChapter(chapter: String) : Book = {this.chapters += chapter; this}

}
