import scala.collection.mutable._

@SerialVersionUID(42L) class Person(val name: String) extends Serializable {

    private val friends = new ArrayBuffer[Person]

    def addFriend(friend: Person) {
        friends += friend
    }
}

import java.io._

object PersonSerializer {

    def serializePeople(people: ArrayBuffer[Person], filename : String = "people.obj") {
        val out = new ObjectOutputStream(new FileOutputStream("/tmp/"+filename))
        out.writeObject(people)
        out.close
    }

    // def deserializePeople(file: String) : ArrayBuffer[Person] = {
    //     val in = new ObjectInputStream(new FileInputStream(file))
           in.readObject().asInstanceOf[ArrayBuffer[Person]]
    // }
}