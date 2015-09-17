import org.junit.Test;

import static org.junit.Assert.*;

public class DequeTests {


    @Test
    public void test_shouldBeAbleToAddFirst() {
        Deque deque = new Deque();
        deque.addFirst(1);
        deque.addFirst(2);
        System.out.println(deque);
    }

    @Test
    public void test_removeFirstShouldRemoveMostRecentItemAddedFirst() {
        Deque deque = new Deque();
        deque.addFirst(1);
        deque.addFirst(2);
        assertEquals(2, deque.removeFirst());
        assertEquals(1, deque.removeFirst());
    }

    @Test
    public void test_removeFirstShouldEventuallyEmptyDeque() {
        Deque deque = new Deque();
        deque.addFirst(1);
        deque.addFirst(2);
        assertEquals(2, deque.removeFirst());
        assertEquals(1, deque.removeFirst());
        assertNull(deque.removeFirst());
    }




}
