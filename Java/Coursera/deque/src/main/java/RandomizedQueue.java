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
        numberOfItems++; //adding an item so the number of items increases by 1
        // TODO add the item - array index corresponds to when the item was added
        final int itemIndex = numberOfItems-1; //OBOB the index corresponding to numberOfItems is nullable
        itemArray[itemIndex] = item;
    }

    public Item oldDequeue() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("This randomized queue is empty!");
        }
        int removedItemIndex = whileLoopRandomIndex();

        Item randomItem = itemArray[removedItemIndex];
        itemArray[removedItemIndex] = null;
        numberOfItems--;
        if (numberOfItems > 0 && numberOfItems == itemArray.length/4) {
            resize(itemArray.length/2);
        }
        // TODO remove and return a random item
        return randomItem;
    }

    public Item dequeue() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("This randomized queue is empty!");
        }
        int removedItemIndex = knownNullRandomIndex();

        numberOfItems--;

        Item swap = itemArray[firstNullableIndex()]; //we're about to nullify an index so get the value out of it
        Item randomItem = itemArray[removedItemIndex]; //get the value out of the randomIndex
        itemArray[removedItemIndex] = swap; //put the nullable index item in the removedItem Index
        itemArray[firstNullableIndex()] = null; //nullify the known null index

        if (numberOfItems > 0 && numberOfItems == itemArray.length/4) {
            resize(itemArray.length/2);
        }
        // TODO remove and return a random item
        return randomItem;
    }

    private int finalItemIndex() {
        return numberOfItems-1;
    }

    private int firstNullableIndex() {
        return numberOfItems;
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

        Item returnValue = itemArray[knownNullRandomIndex()];
        //TODO return (but do not remove) a random item
        return returnValue;
    }

    public Iterator<Item> iterator() {
       return new RandomizedQueueIterator();
    }

    private int whileLoopRandomIndex() {
        //number of items changes -
        int index = StdRandom.uniform(this.itemArray.length);
        while(itemArray[index]== null) { //If we know where the null values are then we can avoid this.
            index = StdRandom.uniform(this.itemArray.length);
        }
        return index;
    }

    private int knownNullRandomIndex() {
        //numberOfItems == nullable index so do not pick it!
        int index = StdRandom.uniform(0, numberOfItems);
        return index;
    }

    public static void main(String[] args) {
        RandomizedQueue testObj = new RandomizedQueue<Integer>();
//        testObj.whileLoopRandomIndex();

    } // unit testing


    private class RandomizedQueueIterator implements Iterator<Item> {

        RandomizedQueue<Item> randomizedQueue;

        // TODO memory usage = Linear in current # of items


        public RandomizedQueueIterator() {
            randomizedQueue = new RandomizedQueue();
            for (Item i : itemArray) { //linear item
                if (null != i) {
                    randomizedQueue.enqueue(i);
                }
            }
        }

        @Override
        public boolean hasNext() {
            return !randomizedQueue.isEmpty();
        }

        @Override
        public Item next() {
            //TODO must be constant worst case
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return randomizedQueue.dequeue();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

/*    private class ReverseArrayIterator implements Iterator<Item> {
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
    }*/
}