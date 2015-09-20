import edu.princeton.cs.algs4.Stopwatch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class DequeTests {

    private static final int N = 10;
    private Deque testObj = new Deque();

    final boolean exceptionThrown = false;


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
    public void supportBulkyIteratorSyntax() {

        Deque<Integer> deque = new Deque();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        Iterator<Integer> it = deque.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            System.out.println(i);
        }

        System.out.println(deque.isEmpty());
    }

    @Test
    public void supportIteratorSyntacticSugar() {

        Deque<Integer> deque = new Deque();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        Iterator<Integer> it = deque.iterator();
        for (int i : deque) {
            System.out.println(i);
        }

        System.out.println(deque.isEmpty());
    }

    @Test
    public void allowsForEach() {
        Deque<Integer> deque = new Deque();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        for (int item : deque) {
            System.out.println(item);
        }
    }

    @Test
    public void removeFirstEmptiesDeque() {
        Deque<Integer> deque = new Deque();
        deque.addFirst(0);
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);

        deque.removeFirst();
        deque.removeLast();
        deque.removeFirst();
        deque.removeLast();
        assertTrue(deque.isEmpty());
        assertEquals(0, deque.size());

    }

    @Test
    public void testDequeCanUseForEach() {
        Deque<Integer> deque = new Deque();
        deque.addFirst(2);
        deque.addFirst(4);
        deque.addFirst(5);
        deque.addFirst(6);
        deque.addFirst(7);

        for (Integer i : deque) {
            System.out.println(i);
        }

        assertFalse(deque.isEmpty());

    }

    @Test
    public void test_emptyDequeThenBackAgain() {
        Deque<Integer> deque = new Deque();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.removeFirst();
        deque.removeLast();
        assertEquals(0, deque.size());
        assertTrue(deque.isEmpty());
        deque.addFirst(4);
        deque.addLast(5);
        assertEquals(2, deque.size());


    }

    @Test
    public void stillReturnsLastIfMultipleItemsAddedFirst() {
        Deque deque = new Deque();
        deque.addFirst(1);
        deque.addFirst(2);

        assertEquals(1, deque.removeLast());
        assertEquals(2, deque.removeLast());
    }

    @Test
    public void stillReturnsLastIfMultipleItemsAddedLast() {
        Deque deque = new Deque();
        deque.addLast(1);
        deque.addLast(2);

        assertEquals(2, deque.removeLast());
        assertEquals(1, deque.removeLast());
    }

    @Test
    public void returnsCorrectValues_afterRmoveLastThenRemoveFirst_oneItemList() {
        Deque deque = new Deque();
        deque.addLast(1);
        deque.addFirst(2);

        assertEquals(1, deque.removeLast());
        assertEquals(2, deque.removeFirst());
    }

    @Test
    public void stillReturnsLastIfMultipleItemsAddedFirstThenLast() {
        Deque deque = new Deque();
        deque.addFirst(2);
        deque.addLast(1);

        assertEquals(2, deque.removeFirst());
        assertEquals(1, deque.removeLast());
    }


    @Test
    public void addFirstShouldAddItemToTheFront_whenNoCallsToAddLast() {
        Integer head = 982;

        Deque deque = new Deque();
        deque.addFirst(1223);
        deque.addFirst(12134);
        deque.addFirst(198);
        deque.addFirst(10);
        deque.addFirst(head);

        assertEquals(5, deque.size());
        assertEquals(head, deque.removeFirst());
        assertEquals(4, deque.size());
    }

    @Test
    public void addLastShouldAddItemToTheFront_whenNoCallsToAddFirst() {
        Integer head = 982;

        Deque deque = new Deque();
        deque.addLast(1223);
        deque.addLast(12134);
        deque.addLast(198);
        deque.addLast(10);
        deque.addLast(head);

        assertEquals(5, deque.size());
        assertEquals(head, deque.removeLast());
        assertEquals(4, deque.size());
    }

    @Test
    public void removeFirstShouldAddRemoveOneItem_fromOneElementDeque_whenOnlyCallsToAddFirst() {
        Integer head = 982;

        Deque deque = new Deque();
        deque.addFirst(head);

        assertEquals(1, deque.size());
        assertEquals(head, deque.removeFirst());
        assertEquals(0, deque.size());
    }

    @Test
    public void removeFirst_ShouldAddRemoveOneItem_fromOneElementDeque_whenOnlyCallsToAddLast() {
        Integer head = 982;

        Deque deque = new Deque();
        deque.addLast(head);

        assertEquals(1, deque.size());
        assertEquals(head, deque.removeFirst());
        assertEquals(0, deque.size());
    }

    @Test
    public void removeLast_ShouldAddRemoveOneItem_fromOneElementDeque_whenOnlyCallsToAddFirst() {
        Integer head = 982;

        Deque deque = new Deque();
        deque.addFirst(head);

        assertEquals(1, deque.size());
        assertEquals(head, deque.removeLast());
        assertEquals(0, deque.size());
    }

    @Test
    public void removeLast_ShouldAddRemoveOneItem_fromOneElementDeque_whenOnlyCallsToAddLast() {
        Integer head = 982;

        Deque deque = new Deque();
        deque.addLast(head);

        assertEquals(1, deque.size());
        assertEquals(head, deque.removeLast());
        assertEquals(0, deque.size());
    }

    @Test
    public void removeLast_shouldWork_WhenAllCallsAreAddFirst() {
        int firstElementAdded = 1;
        int secondElementAdded = 2;

        Deque deque = new Deque();
        deque.addFirst(firstElementAdded);
        deque.addFirst(secondElementAdded);
        deque.addFirst(12134);
        deque.addFirst(198);
        deque.addFirst(10);
        deque.addFirst(982);


        assertEquals(6, deque.size());
        assertEquals(firstElementAdded, deque.removeLast());
        assertEquals(secondElementAdded, deque.removeLast());
    }


    @Test
    public void addFirstShouldAddItemToTheFront_whenAreCallsToAddLast() {
        Integer head = 982;
        Integer finalElement = 976;

        Deque deque = new Deque();
        deque.addFirst(1223);
        deque.addFirst(12134);
        deque.addFirst(198);
        deque.addFirst(10);
        deque.addFirst(head);
        deque.addLast(333);
        deque.addLast(543);
        deque.addLast(finalElement);

        assertEquals(8, deque.size());
        assertEquals(head, deque.removeFirst());
        assertEquals(7, deque.size());
        assertEquals(finalElement, deque.removeLast());
        assertEquals(6, deque.size());
    }

    @Test
    public void sizeShouldReturnNumberOfElementsToDeque() {
        Integer head = 982;
        Integer finalElement = 976;

        Deque deque = new Deque();
        deque.addFirst(1223);
        deque.addFirst(12134);
        deque.addFirst(198);
        deque.addFirst(10);
        deque.addFirst(head);
        deque.addLast(333);
        deque.addLast(543);
        deque.addLast(finalElement);

        assertEquals(8, deque.size());
    }


    @Test
    public void removeFirstShouldRemoveElementsFromDeque_withOrdinalCalls() {
        Deque deque = new Deque();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.addFirst(5);

        deque.addLast(-1);
        deque.addLast(-2);
        deque.addLast(-3);
        deque.addLast(-4);

        assertEquals(5, deque.removeFirst());
        assertEquals(4, deque.removeFirst());
        assertEquals(3, deque.removeFirst());
        assertEquals(2, deque.removeFirst());
        assertEquals(1, deque.removeFirst());
        assertEquals(-4, deque.removeLast());
        assertEquals(-3, deque.removeLast());
        assertEquals(-2, deque.removeLast());
        assertEquals(1, deque.size());
    }

    @Test
    public void removeLastShouldRemoveLastElementFromDeque() {
        Deque deque = new Deque();
        deque.addFirst(1); //1-
        deque.addFirst(2); //2-1
        deque.addLast(3);  //2-1-3
        deque.addLast(4);  //2-1-3-4

        assertEquals(4, deque.removeLast());
        assertEquals(3, deque.removeLast());
        assertEquals(1, deque.removeLast());
        assertEquals(2, deque.removeLast());
    }

    @Test
    public void isEmptyshouldReturnTrueOnAnEmptyDeque() {
        Deque emptyDeque = new Deque();
        assertTrue(emptyDeque.isEmpty());
    }

    @Test
    public void isEmptyshouldReturnTrueOnANonEmptyDeque() {
        Deque deque = largeDeque();
        assertFalse(deque.isEmpty());
    }

    @Test
    public void shouldThrowANullPointerIfTheClientAttemptsToAddANullUItemUsingAddFirst() {
        try {
            testObj.addFirst(null);
            assertTrue(exceptionThrown);
        } catch (NullPointerException ex) {
            assertEquals("You must not add a null Item", ex.getMessage());
        } catch (Exception ex) {
            assertTrue(ex instanceof NullPointerException);
        }
    }

    @Test
    public void shouldThrowANullPointerIfTheClientAttemptsToAddANullUItemUsingAddLast() {
        try {
            testObj.addLast(null);
            assertTrue(exceptionThrown);
        } catch (NullPointerException ex) {
            assertEquals("You must not add a null Item", ex.getMessage());
        } catch (Exception ex) {
            assertTrue(ex instanceof NullPointerException);
        }
    }

    @Test
    public void shouldThrowANoSuchElementExceptionIfTheClientAttemptsToRemoveFirstFromAnEmptyDeque() {
        try {
            testObj.removeFirst();
        } catch (NoSuchElementException ex) {
            assertEquals("You cannot remove from an empty Deque", ex.getMessage());
        } catch (Exception ex) {
            assertTrue(ex instanceof NoSuchElementException);
        }
    }

    @Test
    public void shouldThrowANoSuchElementExceptionIfTheClientAttemptsToRemoveLastFromAnEmptyDeque() {
        try {
            testObj.removeLast();
            assertTrue(exceptionThrown);
        } catch (NoSuchElementException ex) {
            assertEquals("You cannot remove from an empty Deque", ex.getMessage());
        } catch (Exception ex) {
            assertTrue(ex instanceof NoSuchElementException);
        }
    }

    @Test
    public void shouldThrowUnsupportedOperationExceptionWhenCallingRemoveFromIterator() {
        testObj = new Deque();
        try {
            testObj.iterator().remove();
            assertTrue(exceptionThrown);
        } catch (UnsupportedOperationException ex) {
            assertEquals("Iterator does not support remove", ex.getMessage());
        } catch (Exception ex) {
            assertTrue(ex instanceof UnsupportedOperationException);
        }
    }

    @Test
    public void shouldThrowNoSuchElementExceptionWhenCallingNextInAnEmptyIterator() {
        testObj = new Deque();
        try {
            testObj.iterator().next();
            assertTrue(exceptionThrown);
        } catch (NoSuchElementException ex) {
            assertEquals("No more items to return!", ex.getMessage());
        } catch (Exception ex) {
            assertTrue(ex instanceof NoSuchElementException);
        }
    }

    @Test
    public void shouldPerformConstantWorstCaseTimeForAddFirst() {
        int N = 10;

        Deque smallN = new Deque<Integer>();
        for (int i = 0; i < 10; i++) {
            smallN.addFirst(i);
        }
        Stopwatch stopwatch = new Stopwatch();
        smallN.addFirst(9);
        double smallTime = stopwatch.elapsedTime();

        Deque largeN = new Deque<Integer>();
        for (int i = 0; i < N * 10000; i++) {
            largeN.addFirst(i);
        }
        stopwatch = new Stopwatch();
        largeN.addFirst(9);
        double largeTime = stopwatch.elapsedTime();

        assertEquals(smallTime, largeTime, 0);
    }

    @Test
    public void shouldPerformConstantWorstCaseTimeForAddLast() {
        int N = 10;

        Deque smallN = smallDeque();
        Deque largeN = largeDeque();

        Stopwatch stopwatch = new Stopwatch();
        smallN.addLast(9);
        double smallTime = stopwatch.elapsedTime();

        stopwatch = new Stopwatch();
        largeN.addLast(9);
        double largeTime = stopwatch.elapsedTime();

        assertEquals(smallTime, largeTime, 0);
    }

    @Test
    public void shouldPerformConstantWorstCaseTimeForRemoveFirst() {
        int N = 10;

        Deque smallN = smallDeque();
        Deque largeN = largeDeque();

        Stopwatch stopwatch = new Stopwatch();
        smallN.removeFirst();
        double smallTime = stopwatch.elapsedTime();

        stopwatch = new Stopwatch();
        largeN.removeFirst();
        double largeTime = stopwatch.elapsedTime();

        assertEquals(smallTime, largeTime, 0);
    }

    @Test
    public void shouldPerformConstantWorstCaseTimeForRemoveLast() {

        Deque smallN = smallDeque();
        Deque largeN = largeDeque();

        Stopwatch stopwatch = new Stopwatch();
        smallN.removeLast();
        double smallTime = stopwatch.elapsedTime();

        stopwatch = new Stopwatch();
        largeN.removeLast();
        double largeTime = stopwatch.elapsedTime();

        assertEquals(smallTime, largeTime, 0);
    }

    @Test
    public void shouldPerformConstantWorstCaseTimeFor_isEmpty() {
        Deque smallN = smallDeque();
        Deque largeN = largeDeque();

        Stopwatch stopwatch = new Stopwatch();
        smallN.isEmpty();
        double smallTime = stopwatch.elapsedTime();

        stopwatch = new Stopwatch();
        largeN.isEmpty();

        double largeTime = stopwatch.elapsedTime();
        System.out.println(smallTime);
        assertEquals(smallTime, largeTime, 0);
    }

    @Test
    public void jumbledDeque() {

        Deque deque = new Deque<Integer>();
        deque.addFirst(1);
        deque.addFirst(5);
        deque.addLast(7);
        deque.addLast(9);
        deque.addFirst(4326);
        deque.addLast(88);
        deque.addFirst(32);
        deque.addLast(2);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.addLast(89);
        deque.addLast(19);
        ;
        deque.addFirst(0); //0-4-3-32-4326-5-1-7-9-88-2-89-19

        assertEquals(19, deque.removeLast());
        assertEquals(0, deque.removeFirst());
        assertEquals(89, deque.removeLast());
        assertEquals(4, deque.removeFirst());
        assertEquals(2, deque.removeLast());
        assertEquals(3, deque.removeFirst());
    }

    @Test
    public void test_The_order_of_two_or_more_iterators_to_the_same_randomized_queue_must_be_mutually_independent() {

        Deque<Integer> queue1 = sizedDeque(10);

        StringBuilder iterator1Output = new StringBuilder();
        StringBuilder iterator1Output2 = new StringBuilder();

        for (Integer i : queue1) {
            iterator1Output.append(i + " ");
            for (Integer j : queue1) {
                iterator1Output2.append(j + " ");
                System.out.println("DEQUE SIZE == " + queue1.size());
            }
        }

        System.out.println("Outer loop" + iterator1Output.toString());
        System.out.println("Inner loop" + iterator1Output2.toString());
        assertFalse(iterator1Output.toString().equals(iterator1Output2.toString()));

    }


    private Deque sizedDeque(int size) {
        Deque smallDeque = new Deque<Integer>();
        for (int i = 0; i < size/2; i++) {
            smallDeque.addFirst(i);
            smallDeque.addLast(i);
        }
        return smallDeque;
    }

    private Deque smallDeque() {
        Deque smallDeque = new Deque<Integer>();
        for (int i = 0; i < N; i++) {
            smallDeque.addFirst(i);
            smallDeque.addLast(i);
        }
        return smallDeque;
    }

    private Deque largeDeque() {
        Deque largeDeque = new Deque<Integer>();
        for (int i = 0; i < N * 10000; i++) {
            largeDeque.addFirst(i);
            largeDeque.addLast(i);
        }
        return largeDeque;
    }
    
    

}

