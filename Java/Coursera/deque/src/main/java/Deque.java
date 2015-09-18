import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    public Node sentinelNode;
    private int size = 0;

    public Deque() {
        // initialise the sentinel node and attach to itself
        sentinelNode = new Node(null);
        sentinelNode.previous = sentinelNode;
        sentinelNode.next = sentinelNode;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (null == item) {
            throw new NullPointerException("You must not add a null Item");
        }
        Node oldFirst = sentinelNode.next;

        Node newNode = new Node(item);    //1) create a new nodew
        newNode.previous = sentinelNode;  //2) attach the node to the sentinel
        newNode.next = oldFirst;
        sentinelNode.next = newNode;      //3) attach the sentinel to the node
        oldFirst.previous = newNode;        //6) attach previous first to first
        size++;
    }

    public void addLast(Item item) {
        if (null == item) {
            throw new NullPointerException("You must not add a null Item");
        }
        Node oldLast = sentinelNode.previous;

        Node newNode = new Node(item);    //1) create a new nodew
        newNode.next = sentinelNode;  //2) attach the node to the sentinel
        newNode.previous = oldLast;
        sentinelNode.previous = newNode;      //3) attach the sentinel to the node
        oldLast.next = newNode;        //6) attach next Last to Last
        size++;
    }


    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("You cannot remove from an empty Deque");
        }
        Node returnNode = sentinelNode.next;
        Node newFirst = returnNode.next;
        sentinelNode.next = newFirst;
        newFirst.previous = sentinelNode;
        size--;
        return (Item) returnNode.value;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("You cannot remove from an empty Deque");
        }
        Node returnNode = sentinelNode.previous;
        Node newLast = returnNode.previous;
        sentinelNode.previous = newLast;
        newLast.next = sentinelNode;
        size--;
        return (Item) returnNode.value;
    }

    public boolean isEmpty() {
        return sentinelNode.next == sentinelNode && sentinelNode.previous == sentinelNode;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator(this);
    }

    public class Node<Item> {
        Node next;
        Node previous;
        Item value;

        public Node(Item value) {
            this.value = value;
        }

    }

    private class DequeIterator implements Iterator<Item> {

        private Deque<Item> deque;

        public DequeIterator(Deque<Item> deque) {
            this.deque = deque;
        }

        @Override
        public boolean hasNext() {
            return !deque.isEmpty();
        }

        @Override
        public Item next() {
            if (deque.isEmpty()) {
                throw new NoSuchElementException("No more items to return!");
            }
            return deque.removeFirst();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Iterator does not support remove");
        }
    }
}