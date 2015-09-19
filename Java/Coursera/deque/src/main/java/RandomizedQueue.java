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
            itemArray = (Item[]) new Object[2]; //taken from ResizingArrayStack
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
        if (numberOfItems == itemArray.length) {
            resize(2*itemArray.length);
        }

        // TODO add the item - array index corresponds to when the item was added
        final int itemIndex = numberOfItems++;
        itemArray[itemIndex] = item;
    }

    public Item dequeue() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("This randomized queue is empty!");
        }
        int removedItemIndex = randomNotNullIndex();

        Item randomItem = itemArray[removedItemIndex];
        itemArray[removedItemIndex] = null;
        numberOfItems--;
        if (numberOfItems > 0 && numberOfItems == itemArray.length/4) {
            resize(itemArray.length/2);
        }
        // TODO remove and return a random item
        return randomItem;
    }

    private void resize(int capacity) {
        // resize the underlying array holding the elements
            assert capacity >= numberOfItems;
            Item[] temp = (Item[]) new Object[capacity];
            for (int i = 0; i < numberOfItems; i++) {
                temp[i] = itemArray[i];
            }
            itemArray = temp;
        }

    public Item sample() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("This randomized queue is empty!");
        }

        Item returnValue = itemArray[randomNotNullIndex()];
        //TODO return (but do not remove) a random item
        return returnValue;
    }

    public Iterator<Item> iterator() {
        // TODO return an independent iterator over items in random order
        return null;
    }

    private int randomNotNullIndex() {
        //number of items changes -
        int index = StdRandom.uniform(this.itemArray.length);
        while(itemArray[index]== null) {
            index = StdRandom.uniform(this.itemArray.length);
        }
        //TODO need to ensure each added item preserves its index
        return index;
    }

    public static void main(String[] args) {
        RandomizedQueue testObj = new RandomizedQueue<Integer>();
        testObj.randomNotNullIndex();

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

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;

        public ReverseArrayIterator() {
            i = N-1;
        }

        public boolean hasNext() {
            return i >= 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }
    }
}