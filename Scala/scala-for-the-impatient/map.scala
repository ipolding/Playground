
/* Using a mutable map */
val in = new java.util.Scanner(new java.io.File("hello.txt"))
var words = scala.collection.mutable.Map[String, Int]()

// iterate over each words in in
while (in.hasNext()) {
    val word = in.next()
    if (words.getOrElse(word, 0) != 0)  {
        words(word) = words(word) + 1
    } else {
        words += (word -> 1)
    }
}

/* Using an immutable map */
val in = new java.util.Scanner(new java.io.File("hello.txt"))
var words = scala.collection.immutable.Map[String, Int]() //immutable collections used by default

var newWords = Map[String, Int]()

// iterate over each words in in
while (in.hasNext()) {
    val word = in.next()
    if (words.getOrElse(word, 0) != 0)   {
        words = words + (word -> (words(word) + 1))
    } else {
        words =  words + (word -> 1)
}}

/* Using a sorted map*/
val in = new java.util.Scanner(new java.io.File("hello.txt"))
var words = scala.collection.immutable.TreeMap[String, Int]()

// iterate over each words in in
while (in.hasNext()) {
    val word = in.next()
    if (words.getOrElse(word, 0) != 0)   {
        words = words + (word -> (words(word) + 1))
    } else {
        words =  words + (word -> 1)
}}

/* Using a treemap (Java map; with Scala Map API*/

// Simply add an import statement for the conversion to Scala
import scala.collection.JavaConversions.mapAsScalaMap
// trigger the conversion by specifying the Scala map type:
val wordCount: scala.collection.mutable.Map[String, Int] =
new java.util.TreeMap[String, Int]

val in = new java.util.Scanner(new java.io.File("hello.txt"))

// iterate over each words in in
while (in.hasNext()) {
    val word = in.next()
    if (wordCount.getOrElse(word, 0) != 0)  {
        wordCount(word) = wordCount(word) + 1
    } else {
        wordCount += (word -> 1)
    }
}      


/*Define a linked hash map that maps "Monday" to java.util.Calendar.MONDAY , and
similarly for the other weekdays. Demonstrate that the elements are visited
in insertion order. */

var linkedHashMap = collection.mutable.LinkedHashMap[String, Any]()
linkedHashMap += ("Monday" -> java.util.Calendar.MONDAY)
linkedHashMap += ("Tuesday" -> java.util.Calendar.TUESDAY)
linkedHashMap += ("Wednesday" -> java.util.Calendar.WEDNESDAY)
linkedHashMap += ("Thursday" -> java.util.Calendar.THURSDAY)
linkedHashMap += ("Friday" -> java.util.Calendar.FRIDAY)
linkedHashMap += ("Saturday" -> java.util.Calendar.SATURDAY)
linkedHashMap += ("Sunday" -> java.util.Calendar.SUNDAY)

for ((k, v) <- linkedHashMap) {print (k, v)}

var linkedHashMap = collection.mutable.LinkedHashMap[String, Any]()
linkedHashMap += ("Thursday" -> java.util.Calendar.THURSDAY)
linkedHashMap += ("Friday" -> java.util.Calendar.FRIDAY)
linkedHashMap += ("Monday" -> java.util.Calendar.MONDAY)
for ((k, v) <- linkedHashMap) {print (k, v)}

/* vs. */

var normalMap = collection.mutable.Map[String, Any]()
normalMap += ("Thursday" -> java.util.Calendar.THURSDAY)
normalMap += ("Friday" -> java.util.Calendar.FRIDAY)
normalMap += ("Monday" -> java.util.Calendar.MONDAY)
for ((k, v) <- normalMap) {print (k, v)}


/* Q4.7 Print a table of all Java properties, like this:*/
import scala.collection.JavaConversions.propertiesAsScalaMap
val props: scala.collection.Map[String, String] = System.getProperties()
val longestLength  = props.keySet.maxBy(_.length).length

for ((k, v) <- props) {
    println (k.padTo(longestLength, ' ') + "|" + v)
}


/*8. Write a function minmax(values: Array[Int]) that returns a pair containing the
smallest and largest values in the array.*/
def minmax(values: Array[Int]):Tuple2[Int, Int] = {   
    (values.min, values.max)
}


/*9. Write a function lteqgt(values: Array[Int], v: Int) that returns a triple containing
the counts of values less than v , equal to v , and greater than v .*/

def lteqgt(values: Array[Int], v: Int) :Triple[Int, Int, Int]  = {
    var lessThan = 0
    var equal = 0
    var greaterThan = 0
    for (elem <- values) {
        if (elem == v) {equal += 1}
        if (elem > v) {greaterThan += 1}
        else {lessThan += 1}
    }
    (lessThan, equal, greaterThan)
}
lteqgt(Array(1,2,3,4,5,6,7), 4)



/*10. What happens when you zip together two strings, such as "Hello".zip("World") ?
Come up with a plausible use case*/