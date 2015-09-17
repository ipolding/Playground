import java.util.NoSuchElementException;

public class Deque<Item> {

    public Node sentinelNode;
    private int size;

    public Deque() {
    // initialise the sentinel node and attach to itself
        sentinelNode = new Node(null);
        sentinelNode.previous = sentinelNode;
        sentinelNode.next = sentinelNode;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "Deque{" +
                "first=" + first() +
                ", last=" + last() +
                ", size=" + size +
                '}';
    }

    public Node first() {
        return sentinelNode.next;
    }

    public Node last() {
        return sentinelNode.previous;
    }

    public void addFirst(Item item) {
        Node oldFirst = sentinelNode.next;

        Node newNode = new Node(item);    //1) create a new nodew
        newNode.previous = sentinelNode;  //2) attach the node to the sentinel
        newNode.next = oldFirst;
        sentinelNode.next = newNode;      //3) attach the sentinel to the node
        oldFirst.previous = newNode;        //6) attach previous first to first
        size++;

    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("The deque is empty!");
        }
        Node returnNode = sentinelNode.next;
        sentinelNode.next = returnNode.next;
        return (Item) returnNode.value;
    }

    public boolean isEmpty() {
        return sentinelNode.next ==null && sentinelNode.previous == null;
    }

    public class Node<Item> {
        public Node next;
        public Node previous;
        public Item value;

        public Node(Item value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public void setValue(Item value) {
            this.value = value;
        }

    }

}
