/*
 Implement the equals method for the Member class that is nested inside the Network class in Section 18.2 "Type Projections"
  
 For two members to be equal, they need to be in the same network.
*/
import scala.collection.mutable.ArrayBuffer

class Network(name: String) {
    class Member(val name: String) {
<<<<<<< HEAD
    
    val contacts = new ArrayBuffer[Member]
    val outer = Network.this

    override def equals(arg: Any) : Boolean = {

        if (arg.isInstanceOf[Network#Member]) {
        // if members are in the same network, then they are considered equal
        arg.asInstanceOf[Network#Member].outer == this.outer
        } else {false}
=======
        val contacts = new ArrayBuffer[Member]
        val outer = Network.this    


    override def equals(arg: Any) : Boolean = {
        if (arg.isInstanceOf[Network#Member]){
            arg.asInstanceOf[Network#Member].outer == Network.this
        } else {false}
    }
>>>>>>> 8665373ca72320e8e86aea37fb8317adede953f3
    }
}
    
    private val members = new ArrayBuffer[Member]

    def join(name: String) = 
{        val m = new Member(name)
        members += m
        m
    }
}

import org.scalatest._

class NetworkMemberEqualsTest extends FlatSpec {

"A network member equals method" should "return true for members of the same network" in
    {val myFace = new Network("My Face")
     val mark = new myFace.Member("Mark Zuckerburg")
     val tom = new myFace.Member("Tom Anderson")
     assert(tom equals mark) 
    }

it should "return false for members of different networks" in
    {
        val chatter = new Network("Chatter")
        val stephen = new chatter.Member("Stephen Fry")
        val myFace = new Network("My Face")
        val fry = new myFace.Member("Stephen Fry")
<<<<<<< HEAD
        assert(stephen equals fry == false)
    }   
}
=======
        assert((stephen equals fry) == false)
    }   
}

>>>>>>> 8665373ca72320e8e86aea37fb8317adede953f3
