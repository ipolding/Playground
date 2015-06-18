// Implement a Bug class modelling a bug that moves along a horizontal line
// set up method chaining!!

class Bug {

var direction : Boolean = true
var position = 0;
/** 
Moves in the current direction 
@param distance How far should the Bug move along the x-axis?
*/
def move(distance: Int) : this.type =  {
    if (direction) position += distance else position -= distance 
    this
}

/**
Turn makes the bug turn around
*/
def turn() : this.type =  {
    direction = !direction
    this
}

/**
show prints the current position
*/

def show() : this.type =  {
        println("Direction: " + (if (this.direction) "forward" else "reverse"))
        println("Position: " + position)
        this
}

}