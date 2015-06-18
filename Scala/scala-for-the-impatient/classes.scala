/*1. Improve the Counter class in Section 5.1, “Simple Classes and Parameterless
Methods,” on page 49 so that it doesn’t turn negative at Int.MaxValue .*/

class CounterA {
    private var value = 0
    def increment() { // mutator so call using parentheses
        if (value != Int.MaxValue) 
        value += 1} 
    def current() = value // Accessor. should be called without parenthes
}

/*scala> val myCounter = new Counter
scala> for (i <- 0 until Int.MaxValue) myCounter.increment()
scala> myCounter.current
res1: Int = 2147483647
scala> myCounter.increment

scala> myCounter.current
res3: Int = 2147483647*/

class CounterB {
    private var value = 0
    def increment() { // mutator so call using parentheses
       //f (value != Int.MaxValue) 
        value += 1} 
    def current() = value // Accessor. should be called without parenthes
}
/*2. Write a class BankAccount with methods deposit and withdraw , and a read-only
property balance .*/
class BankAccount(private var balance: Double) {

    def deposit(amount: Double) {
        balance += amount
    }

    def withdraw(amount: Double) {
        balance -= amount
    }
    def current = balance
}

/*scala> var myAccount = new BankAccount(100)
scala> myAccount.deposit(10.36)
scala> myAccount.withdraw(12.76
scala> myAccount.balance
<console>:10: error: variable balance in class BankAccount cannot be accessed in BankAccount
scala> myAccount.current
res10: Double = 97.6*/

/*3. Write a class Time with read-only properties hours and minutes and a method
before(other: Time): Boolean that checks whether this time comes before the
other. A Time object should be constructed as new Time(hrs, min) , where hrs is in
military time format (between 0 and 23).*/
class TimeA(private var hours :Int, private var minutes : Int) {
    if (hours < 0 || hours > 23 || minutes < 0  || minutes > 59) {
        throw new IllegalArgumentException("Hours must be between 0 and 23. Minutes must be between 0 and 59")
    }

    def hrs = hours
    def mins = minutes

    def before(other: TimeA) : Boolean = {
        (this.hrs <= other.hrs) && (this.mins < other.mins)
    }
}

/*4. Reimplement the Time class from the preceding exercise so that the internal
representation is the number of minutes since midnight (between 0 and
24 × 60 – 1). Do not change the public interface. That is, client code should be
unaffected by your change.*/

class TimeB(hours :Int, minutes : Int) {
    if (hours < 0 || hours > 24 || minutes < 0  || minutes > 59) {
        throw new IllegalArgumentException("Hours must be between 0 and 24. Minutes must be between 0 and 59")
    }

    private val time : Int = hours * 60 + minutes 
    def hrs = (time - minutes) / 60
    def mins = time - hours * 60

    def before(other: TimeB) : Boolean = {
        (this.hrs <= other.hrs) && (this.mins < other.mins)
    }
}
//val mt = new Time(20,32)


/*5. Make a class Student with read-write JavaBeans properties name (of type String )
and id (of type Long ). What methods are generated? (Use javap to check.) Can
you call the JavaBeans getters and setters in Scala? Should you?*/

// I think... getName setName, getId and setId will be generated
// Actually.. You get Java setters and getters, and scala field() and field_=

import scala.reflect.BeanProperty

class Student (@BeanProperty var name: String, @BeanProperty var id: Long)

/*6. In the Person class of Section 5.1, “Simple Classes and Parameterless Methods,”
on page 49, provide a primary constructor that turns negative ages to 0.*/

class Person(var age: Int) { // This is Java
    if (age < 0) {age = 0        }
}

/*7. Write a class Person with a primary constructor that accepts a string containing
a first name, a space, and a last name, such as new Person("Fred Smith") . Supply
read-only properties firstName and lastName . Should the primary constructor
parameter be a var , a val , or a plain parameter? Why?*/

// I have used neither val nor var. THe name is just used as a variable by the constructor.

class PersonB(name: String) {
    val firstName = name.split(" ")(0)
    val lastName = name.split(" ")(1)
}

/*8. Make a class Car with read-only properties for manufacturer, model name,
and model year, and a read-write property for the license plate. Supply four
constructors. All require the manufacturer and model name. Optionally,
model year and license plate can also be specified in the constructor. If not,
the model year is set to -1 and the license plate to the empty string. Which
constructor are you choosing as the primary constructor? Why?*/

class Car(var manufacturer : String, var modelName : String) {
    private var year : Int = -1
    private var licensePlate : String = ""

    def this(manufacturer: String, 
        modelName : String, 
        year: Int, 
        licensePlate: String) {
        this(manufacturer, modelName)
        this.year =  year
        this.licensePlate = licensePlate
    }

    def this(manufacturer: String, modelName: String, year: Int) {
        this(manufacturer, modelName)
        this.year = year
    }

    def this(manufacturer: String, modelName: String, licensePlate: String) {
        this(manufacturer, modelName)
        this.licensePlate = licensePlate
    }
}


/*9. Reimplement the class of the preceding exercise in Java, C#, or C++ (your
choice). How much shorter is the Scala class?*/

/*10. Consider the class
class Employee(val name: String, var salary: Double) {
def this() { this("John Q. Public", 0.0) }
}
Rewrite it to use explicit fields and a default primary constructor. Which form
do you prefer? Why?*/

class Employee(val name: String = "John Q. Public", var salary: Double = 0.0) {
    
}