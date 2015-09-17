import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class DequeTests {


    @Test
    public void test_shouldBeAbleToAddFirst() {
        Deque deque = new Deque();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.addFirst(5);
        deque.addFirst(6);
        deque.addFirst(7);

        System.out.println("Head of deque is " + deque.first().value);
        System.out.println("Next in deque is " + deque.first().next.value);
        System.out.println("Next in deque comes after = " + deque.first().next.previous.value);
        System.out.println("Next in deque comes before = " + deque.first().next.next.value);
        System.out.println(deque.first().previous.value + "::" + deque.first().value + "::" + deque.first().next.value + "::" + deque.first().next.next.value);

        assertEquals(7, deque.size());

        System.out.println("Sentinel node's previous is = " + deque.sentinelNode.previous.value);
    }


}