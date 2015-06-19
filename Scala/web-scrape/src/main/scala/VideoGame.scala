import org.jsoup.Jsoup
import org.jsoup.select.{Elements}
import org.jsoup.nodes.{Document, Element}

case class VideoGame(name: String, length : Double)

object VideoGame {
  val html : String = "<html><head><title>First parse</title></head><body><p>Parsed HTML into a doc.</p></body></html>";

  val testJsoup : Unit = {
    val url1 = "http://www.howlongtobeat.com/game.php?id=12965";
    val url2 = "http://google.com";
    val doc : Document = Jsoup.connect(url1).userAgent("Mozilla/5.0 (Linux; <Android Version>; <Build Tag etc.>) AppleWebKit/<WebKit Rev> (KHTML, like Gecko) Chrome/<Chrome Rev> Mobile Safari/<WebKit Rev>").get()
    print(doc.title())
  }

}
