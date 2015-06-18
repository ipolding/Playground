/*

Strategy 1: create an array from the file and do the calculatarions

*/

import scala.io.Source

class FloatCalculator(filename: String) {

    val numbers = Source.fromFile(filename).mkString.split("""\s+""").map(_.toDouble)

    def getSum = numbers.sum

    def getAverage : Double = getSum / numbers.length

    def getMin = numbers.min

    def getMax = numbers.max
}