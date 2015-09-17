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

        System.out.println("Head of deque is " + deque.first.value);
        System.out.println("Next in deque is " + deque.first.next.value);
        System.out.println("Next in deque comes after = " + deque.first.next.previous.value);
        System.out.println("Next in deque comes before = " + deque.first.next.next.value);
        System.out.println(deque.first.previous.value + "::" + deque.first.value + "::" + deque.first.next.value + "::" + deque.first.next.next.value);

        assertEquals(7, deque.size());
    }

    @Test
    public void test_removeFirstShouldRemoveMostRecentItemAddedFirst() {
        Deque deque = new Deque();
        deque.addFirst(1);
        deque.addFirst(2);

        System.out.println(deque.first.value);
        System.out.println(deque.first.next.value);
        System.out.println("Remove first");
        assertEquals(2, deque.removeFirst());
        System.out.println(deque.first.value);
        System.out.println(deque.first.next.value);
        System.out.println("Remove first");
        assertEquals(1, deque.removeFirst());
        System.out.println(deque.first.value);
        System.out.println(deque.first.next);
    }

    @Test
    public void test_removeLastShouldRemoveLastElement_WhenOnlyCallsToAddFirst() {
        Deque deque = new Deque();
        deque.addFirst(1);
        deque.addFirst(2);
        assertEquals(1, deque.removeLast());
        assertEquals(2, deque.removeLast());

    }

    @Test
    public void test_removeFirstShouldEventuallyEmptyDeque() {
        Deque deque = new Deque();
        deque.addFirst(1);
        deque.addFirst(2);
        assertEquals(2, deque.removeFirst());
        assertEquals(1, deque.removeFirst());
        try {
            deque.removeFirst();
        } catch (Exception ex) {
            assertTrue(ex instanceof NoSuchElementException);
            assertEquals("The deque is empty!", ex.getMessage());
        }
    }
}