import scala.io.Source

object FloatStripper {

    val FLOAT_REGEX = """\d+\.\d+\w+""".r

    def stripFloats(filename: String) {
        val tokens = Source.fromFile(filename).mkString.split("""\s+""")
        
        for (token <- tokens if FLOAT_REGEX.findPrefixMatchOf(token) == None) println(token) 
    }
}