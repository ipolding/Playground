import scala.io.Source

object SrcFinder {

    val SRC_REGEX = """img\s+[^>]*src="([^"]*)""".r


    def printSrc(webaddress: String) {
        val html = Source.fromURL(webaddress, "UTF-8").mkString

        for (SRC_REGEX(s) <- SRC_REGEX findAllIn html) println(s)


    }


}