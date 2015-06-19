import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;

object Scraper extends App{
//  VideoGame.testJsoup

  val safeWord = "sausages"

  val bufferedReader : BufferedReader = new BufferedReader(new FileReader(Paths.get("/ian.txt").toFile))

  while (true) {
    val fileLine : String = bufferedReader.readLine()

    if (null != fileLine) {
      print(fileLine + "\n")

      if (fileLine.equalsIgnoreCase(safeWord)) {
        print("That's the safe word! I guess the fun's over!")
        bufferedReader.close()
      }
    }
    Thread.sleep(5000)
    }
}