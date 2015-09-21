import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node<Item> sentinelNode;
    private int size = 0;

    public Deque() {
        // initialise the sentinel node and attach to itself
        sentinelNode = new Node<Item>(null);
        sentinelNode.previous = sentinelNode;
        sentinelNode.next = sentinelNode;
    }

    public static void main(String[] args) {

    }

    public boolean isEmpty() {
        return sentinelNode.next == sentinelNode
                &&
                sentinelNode.previous == sentinelNode;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (null == item) {
            throw new NullPointerException("You must not add a null Item");
        }
        Node<Item> oldFirst = sentinelNode.next;

        Node<Item> newNode = new Node<Item>(item);    //1) create a new nodew
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
        Node<Item> oldLast = sentinelNode.previous;

        Node<Item> newNode = new Node<Item>(item);    //1) create a new nodew
        newNode.next = sentinelNode;  //2) attach the node to the sentinel
        newNode.previous = oldLast;
        sentinelNode.previous = newNode;      //3) attach the sentinel to the node
        oldLast.next = newNode;        //6) attach next Last to Last
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                    "You cannot remove from an empty Deque");
        }
        Node<Item> returnNode = sentinelNode.next;
        Node<Item> newFirst = returnNode.next;
        sentinelNode.next = newFirst;
        newFirst.previous = sentinelNode;
        size--;
        return returnNode.value;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                    "You cannot remove from an empty Deque");
        }
        Node<Item> returnNode = sentinelNode.previous;
        Node<Item> newLast = returnNode.previous;
        sentinelNode.previous = newLast;
        newLast.next = sentinelNode;
        size--;
        return returnNode.value;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class Node<Item> {
        private Node<Item> next;
        private Node<Item> previous;
        private Item value;

        private Node(Item value) {
            this.value = value;
        }

    }

    private class DequeIterator implements Iterator<Item> {
        private Node<Item> current = sentinelNode.next;

        public boolean hasNext() {
            return current != sentinelNode;
        }

        public void remove() {
            throw new UnsupportedOperationException(
                    "Iterator does not support remove");
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more items to return!");
            }
            Item item = current.value;
            current = current.next;
            return item;
        }
    }

}