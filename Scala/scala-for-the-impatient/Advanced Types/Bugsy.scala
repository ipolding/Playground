// bugsy move 4 and show and then move 6 and show turn around move 5 and show
object show
object then
object around

import org.scalatest._
  
  class BugsyTest extends FlatSpec {
  
      "Bugsy" should "move 4, then show himself, then move 6 and show himself, then turn around, move 6 and show himself" in
       {
          val bugsy = new Bugsy
      bugsy move 4 and show and then move 6 and show turn around move 5 and show
  
          assert(bugsy.position == 5)
      }
}

class Bugsy {

    var direction : Boolean = true
    var position = 0;
   
    def move(distance: Int) : this.type =  {
          if (direction) position += distance else position -= distance
          this
    }
  
    def showLocationCode = {
          println("Here I am at position " + position + "!")
    }
  
    def and(arg: show.type) : this.type = {
	    showLocationCode
		this
	}

	def and(arg: then.type) : this.type = {
		this
	}
  
    def turn() : this.type =  {
          direction = !direction
          this
    }

	def turn(arg: around.type) : this.type = {turn}
  } 
