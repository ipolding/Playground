import collection.mutable.Stack
import org.scalatest._

class ExampleSpec extends FlatSpec with Matchers {
	// this class will have the member functions of FlatSpec and it will also have the memebr functions of Matchers

	"A stack" should "pop values in last-in-first-out order " in {
		val stack = new Stack[Int]
		stack.push(1)
		stack.push(2)
		stack.pop() should be (2)
		stack.pop() should be (1)
	}

	it should "throw NoSuchElementException if an empty stack is popped" in {
		val emptyStack = new Stack[Int]
		a [NoSuchElementException] should be thrownBy {
			emptyStack.pop()
		}
	}
}