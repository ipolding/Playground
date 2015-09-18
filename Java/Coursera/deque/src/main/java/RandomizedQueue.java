import java.util.Iterator;
import java.util.NoSuchElementException;

// Create a generic data type RandomizedQueue
public class RandomizedQueue<Item> implements Iterable<Item> {

    int size = 0;

    //item removed is chosen uniformly at random from items in the data structure.
    //implements the following API:

    // construct an empty randomized queue
    public RandomizedQueue() {
    }

    public boolean isEmpty() {
        return false;
    }                // is the queue empty?

    public int size() {
        // TODO return the number of items on the queue
        return size;
    }

    public void enqueue(Item item) {
        if (null == item) {
            throw new NullPointerException("You must not add a null Item");
        }
        // TODO Throw a java.lang.NullPointerException if the client attempts to add a null item;
        // TODO add the item
    }

    public Item dequeue() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("This randomized queue is empty!");
        }
        // TODO remove and return a random item
        return null;
    }

    public Item sample() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("This randomized queue is empty!");
        }
        //TODO return (but do not remove) a random item
        return null;
    }

    public Iterator<Item> iterator() {
        // TODO return an independent iterator over items in random order
        return null;
    }

    public static void main(String[] args) {

    } // unit testing


    private class RandomizedQueueIterator implements Iterator<Item> {

        //Corner cases. The order of two or more iterators to the same randomized queue must be mutually independent; each iterator must maintain its own random order.  throw a java.util.NoSuchElementException if the client attempts to sample or dequeue an item from an empty randomized queue; throw a java.lang.UnsupportedOperationException if the client calls the remove() method in the iterator; throw a java.util.NoSuchElementException if the client calls the next() method in the iterator and there are no more items to return.

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Item next() {
            return null;
        }

        @Override
        public void remove() {

        }
    }

    //Performance requirements. Your randomized queue implementation must support each randomized queue operation (besides creating an iterator) in constant amortized time. That is, any sequence of M randomized queue operations (starting from an empty queue) should take at most cM steps in the worst case, for some constant c. A randomized queue containing N items must use at most 48N + 192 bytes of memory. Additionally, your iterator implementation must support operations next() and hasNext() in constant worst-case time; and construction in linear time; you may (and will need to) use a linear amount of extra memory per iterator.


}