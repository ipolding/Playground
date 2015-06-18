// Implement a Bug class modelling a bug that moves along a horizontal line
// set up a fluent interface
// Test case: bugsy move 4 and show and then move 6 and show turn around move 5 and show

import org.scalatest._

class FluentBugTest extends FlatSpec {

	"Bugsy" should "move 4, then show himself, then move 6 and show himself, then turn around, move 6 and show himself" in
     {
		val bugsy = new Bugsy	
	bugsy move 4 and show and then move 6 and show turn around move 5 and show

		assert(bugsy.direction == 5)
	}




}



class FluentBug {

    var direction : Boolean = true
    var position = 0;

    def move(distance: Int) : this.type =  {
        if (direction) position += distance else position -= distance 
        this
    };

    def show : this.type = {
        println("Here I am at position " + position + "!")
        this
    };

    def and : this.type = this

    def turn() : this.type =  {
        direction = !direction
        this
    };
}
