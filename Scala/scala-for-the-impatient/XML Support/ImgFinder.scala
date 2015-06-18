import scala.xml.XML
import scala.xml.Elem
import java.net.URL
import java.io.FileInputStream

object ImgFinder {

	val IMG_TAG = "img"

    def printImgNoAltFromUrl(webaddress: String) {

		val html : Elem = XML.load(new URL(webaddress))
		print(html.mkString)

    }

    def printImgNoAltFromFile(filepath: String) {

		val html : Elem = XML.load(new FileInputStream(filepath))
		// print(html.mkString)
		
		for (node <- html \\ IMG_TAG) {
			node match {
				case node if (node.attributes("alt") != null) => print(node)                
		} 		
    }
}
}