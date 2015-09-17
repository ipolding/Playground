
public class Deque<Item> {

    private Node sentinelNode;

    private Node first = sentinelNode;
    private Node last = sentinelNode;
    private int size;

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
        first = new Node(sentinelNode, item, oldFirst);
    }

    public Item removeFirst() {
        Node returnNode = first;
        first = first.next;
        return (Item) returnNode.value;
    }

    private class Node<Item> {
        private Node next;
        private Node previous;
        private Item value;

        public Node(Node previous, Item value, Node next) {
            this.next = next;
            this.previous = previous;
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

        @Override
        public String toString() {
            return "Node{" +
                    "next=" + next +
                    ", value=" + value +
                    ", previous=" + previous +
                    '}';
        }
    }

}
