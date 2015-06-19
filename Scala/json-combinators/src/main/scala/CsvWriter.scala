import java.io.{File, PrintWriter}
import org.apache.commons.csv.{CSVFormat, CSVPrinter}

object CsvWriter {

  val outputFile = new File("output.csv")

  def recordPollutant(authorities : List[Authority], pollutant: String): Unit = {
    val csvPrinter = new CSVPrinter(new PrintWriter(outputFile), CSVFormat.RFC4180)
    csvPrinter.printRecord("Authority", pollutant)
    authorities.foreach(auth => csvPrinter.printRecord(auth.name.toString, auth.average.toString))
    csvPrinter.flush()
    csvPrinter.close()
  }
  
}
