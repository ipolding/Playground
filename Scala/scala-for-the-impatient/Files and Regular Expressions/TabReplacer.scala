import scala.io.Source
import java.io.PrintWriter

object TabReplacer {

    private val TAB_REGEX = """\t""".r

    def replaceTabsWithSpaces(filename: String, columnBoundary: Int) {
        val originalFile = Source.fromFile(filename)
        val fileContents = originalFile.mkString
        originalFile.close

        var spaces = " " * columnBoundary

        val writer = new PrintWriter(filename)
        val replacedContents = TAB_REGEX.replaceAllIn(fileContents, spaces)
        writer.print(replacedContents)
        writer.close
    }    

}