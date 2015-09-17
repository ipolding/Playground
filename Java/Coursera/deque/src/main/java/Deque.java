import java.util.NoSuchElementException;

public class Deque<Item> {

    public Node sentinelNode;

    public Node first;
    public Node last;
    private int size;

    public Deque() {
    // initialise the sentinel node and attach to itself
        sentinelNode = new Node(null);
        sentinelNode.previous = sentinelNode;
        sentinelNode.next = sentinelNode;
        first = sentinelNode;
        last = sentinelNode;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "Deque{" +
                "first=" + first +
                ", last=" + last +
                ", size=" + size +
                '}';
    }

    public void addFirst(Item item) {
        Node oldFirst = first;

        Node newNode = new Node(item);    //1) create a new nodew
        newNode.previous = sentinelNode;  //2) attach the node to the sentinel
        sentinelNode.next = newNode;      //3) attach the sentinel to the node
        first = sentinelNode.next;        //4) re-define first
        first.next = oldFirst;            //5) attach first to previous first
        oldFirst.previous = first;        //6) attach previous first to first
        size++;

    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("The deque is empty!");
        }
        Node returnNode = first;
        first = returnNode.next;
        return (Item) returnNode.value;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("The deque is empty!");
        }
        Node returnNode;
        if (last == sentinelNode) {
            returnNode = first;
            first = sentinelNode;
        } else {
            returnNode = last;
            last = returnNode.previous;
        }
        return (Item) returnNode.value;
    }

    public boolean isEmpty() {
        return first == sentinelNode && last == sentinelNode;
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
