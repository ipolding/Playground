import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Create a generic data type RandomizedQueue
public class RandomizedQueue<Item> implements Iterable<Item> {

    int numberOfItems = 0;
    private Item[] itemArray;         // array of items

    //item removed is chosen uniformly at random from items in the data structure.
    //implements the following API:

    // construct an empty randomized queue
    public RandomizedQueue() {
    }

    public boolean isEmpty() {
        return numberOfItems == 0; // is the queue empty?
    }

    public int size() {
        // TODO return the number of items on the queue
        return numberOfItems;
    }

    public void enqueue(Item item) {
        if (null == item) {
            throw new NullPointerException("You must not add a null Item");
        }
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

        Item returnValue = itemArray[randomIndex()];
        //TODO return (but do not remove) a random item
        return returnValue;
    }

    public Iterator<Item> iterator() {
        // TODO return an independent iterator over items in random order
        return null;
    }

    private int randomIndex() {
        return StdRandom.uniform(this.numberOfItems); //TODO won't be this simple - we need a guarantee we're not accessing an empty index
    }

    public static void main(String[] args) {
        RandomizedQueue testObj = new RandomizedQueue<Integer>();
        testObj.randomIndex();

    } // unit testing


    private class RandomizedQueueIterator implements Iterator<Item> {

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
}