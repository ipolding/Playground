/*1. Write an object Conversions with methods inchesToCentimeters , gallonsToLiters , and
milesToKilometers .*/

object Conversions {

	val LITERS_IN_GALLON = 4.54609
	val CENTIMETERS_IN_INCH = 2.54
	val KILOMETERS_IN_MILE = 1.609344


	def inchesToCentimeters(inches: Double) : Double = {
		inches * CENTIMETERS_IN_INCH
	}

	def gallonsToLiters(gallons: Double) : Double = {
		gallons * LITERS_IN_GALLON
	}

	def milesToKilometers(miles: Double) : Double = {
		miles * KILOMETERS_IN_MILE
	}

}


/*2. The preceding problem wasn’t very object-oriented. Provide a general super-
class UnitConversion and define objects InchesToCentimeters , GallonsToLiters , and
MilesToKilometers that extend it. */


/*3. Define an Origin object that extends java.awt.Point . Why is this not actually a
good idea? (Have a close look at the methods of the Point class.)*/


/*4. Define a Point class with a companion object so that you can construct Point
instances as Point(3, 4) , without using new .*/


/*5. Write a Scala application, using the App trait, that prints the command-line
arguments in reverse order, separated by spaces. For example, scala Reverse
Hello World should print World Hello .*/


/*6. Write an enumeration describing the four playing card suits so that the toString
method returns ♣, ♦, ♥, or ♠.*/


/*7. Implement a function that checks whether a card suit value from the preceding
exercise is red.*/

/*
/*8. Write an enumeration describing the eight corners of the RGB color cube. As
IDs, use the color values (for example, 0xff0000 for Red ).