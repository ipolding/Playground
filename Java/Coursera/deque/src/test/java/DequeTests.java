import org.junit.Test;

import static org.junit.Assert.*;

public class DequeTests {


    @Test
    public void test_shouldBeAbleToAddFirst_thenRemoveFirstInReverseOrder() {
        Deque deque = new Deque();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);

        assertEquals(3, deque.removeFirst());
        assertEquals(2, deque.removeFirst());
        assertEquals(1, deque.removeFirst());
    }

    @Test
    public void test_shouldStartEmpty() {
        assertTrue(new Deque<Integer>().isEmpty());
    }

    @Test
    public void removeFirstShouldEmptyDeque() {

        Deque deque = new Deque();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);

        assertEquals(3, deque.removeFirst());
        assertEquals(2, deque.removeFirst());
        assertEquals(1, deque.removeFirst());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void removeLastShouldWorkWithCallsToAddFirst() {

        Deque deque = new Deque();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);

        assertEquals(1, deque.removeLast());
        assertEquals(2, deque.removeLast());
        assertEquals(3, deque.removeLast());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void test_shouldBeAbleToAddLast_thenRemoveLastInReverseOrder() {
        Deque deque = new Deque();
        deque.addLast(1);
            assertEquals(1, deque.size());
        deque.addLast(2);
            assertEquals(2, deque.size());
        deque.addLast(3);
            assertEquals(3, deque.size());

        assertEquals(3, deque.removeLast());
        assertEquals(2, deque.removeLast());
            assertEquals(1, deque.size());
        assertEquals(1, deque.removeLast());
            assertEquals(0, deque.size());
    }

    @Test
    public void removeFirstShouldWorkWithCallsToAddLast() {

        Deque deque = new Deque();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        assertEquals(1, deque.removeFirst());
        assertEquals(2, deque.removeFirst());
        assertEquals(3, deque.removeFirst());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void removeLastShouldEmptyDeque() {

        Deque deque = new Deque();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        assertEquals(3, deque.removeLast());
        assertEquals(2, deque.removeLast());
        assertEquals(1, deque.removeLast());
        assertEquals(0, deque.size());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void createsIterator() {
        Deque<Integer> deque = new Deque();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        for (int i : deque) {
            System.out.println(i);
        }
    }

}