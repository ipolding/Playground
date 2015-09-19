import edu.princeton.cs.algs4.Stopwatch;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class RandomizedQueueTest extends TestCase {

    final boolean exceptionThrown = false;

    @Test
    public void test_starts_off_empty() {
        RandomizedQueue<String> testObj = new RandomizedQueue();
        assertTrue(testObj.isEmpty());
    }

    @Test
    public void oneElementQ_sampleAlwaysReturnsSameElement() {
        RandomizedQueue<Integer> testObj = new RandomizedQueue();
        testObj.enqueue(1);

        for (int i = 0; i < 10; i++) {
            assertEquals(1, (int) testObj.sample());
        }
    }

    @Test
    public void oneElementQ_dequeueAlwaysReturnsSameElement() {

        for (int i = 0; i < 10; i++) {
            RandomizedQueue<Integer> testObj = new RandomizedQueue();
            testObj.enqueue(1);
            assertEquals(1, (int) testObj.dequeue());
            assertTrue(testObj.isEmpty());
        }
    }

    @Test
    public void twoElementQ_dequeAlwaysReturnsOneOfTwoElements() {
        //TODO debug stack overflow
        for (int i = 0; i < 10; i++) {
            RandomizedQueue<Integer> testObj = new RandomizedQueue();
            testObj.enqueue(1);
            testObj.enqueue(2);
            int firstToComeOut = testObj.dequeue();
            int secondToComeOut = testObj.dequeue();
            assertTrue(firstToComeOut == 1 || firstToComeOut == 2);
            assertTrue(testObj.isEmpty());
        }
    }

    @Test
    public void test_The_order_of_two_or_more_iterators_to_the_same_randomized_queue_must_be_mutually_independent() {
        assertTrue(false);
    }

    @Test
    public void test_each_iterator_must_maintain_its_own_random_order() {
        assertTrue(false);
    }

    @Test
    public void test_Throw_a_NullPointerException_if_the_client_attempts_to_add_a_null_item() {
        RandomizedQueue<Integer> testObj = new RandomizedQueue();
        try {
            testObj.enqueue(null);
            assertTrue(exceptionThrown);
        } catch (NullPointerException ex) {
            assertEquals("You must not add a null Item", ex.getMessage());
        } catch (Exception ex) {
            assertTrue(ex instanceof NullPointerException);
        }
    }

    @Test
    public void test_throw_a_NoSuchElementException_if_the_client_attempts_to_sample_an_item_from_an_empty_randomized_queue() {
        RandomizedQueue<Integer> testObj = new RandomizedQueue();
        try {
            testObj.sample();
            assertTrue(exceptionThrown);
        } catch (NoSuchElementException ex) {
            assertEquals("This randomized queue is empty!", ex.getMessage());
        }
    }

    @Test
    public void test_throw_a_NoSuchElementException_if_the_client_attempts_to_an_item_from_an_empty_randomized_queue() {
        RandomizedQueue<Integer> testObj = new RandomizedQueue();
        try {
            testObj.dequeue();
            assertTrue(exceptionThrown);
        } catch (NoSuchElementException ex) {
            assertEquals("This randomized queue is empty!", ex.getMessage());
        }
    }

    @Test
    public void test_throw_a_java_UnsupportedOperationException_if_the_client_calls_the_remove_method_in_the_iterator() {
        RandomizedQueue<Integer> testObj = new RandomizedQueue();
        try {
            testObj.enqueue(null);
            assertTrue(exceptionThrown);
        } catch (UnsupportedOperationException ex) {
            assertEquals("You must not add a null Item", ex.getMessage());
        } catch (Exception ex) {
            assertTrue(ex instanceof NullPointerException);
        }
    }

    @Test
    public void test_throw_a_java_NoSuchElementException_if_the_client_calls_the_next_method_in_the_iterator_and_there_are_no_more_items_to_return() {
        RandomizedQueue<Integer> testObj = new RandomizedQueue();
        try {
            testObj.enqueue(null);
            assertTrue(exceptionThrown);
        } catch (NoSuchElementException ex) {
            assertEquals("You must not add a null Item", ex.getMessage());
        } catch (Exception ex) {
            assertTrue(ex instanceof NullPointerException);
        }
    }

    @Test
    public void test_constantTime_for_size() {
        RandomizedQueue largeN = largeQueue();

        Stopwatch stopwatch = new Stopwatch();
        largeN.size();
        double smallTime = stopwatch.elapsedTime();


        RandomizedQueue smallN = smallQueue();

        stopwatch = new Stopwatch();
        smallN.size();
        double largeTime = stopwatch.elapsedTime();

        assertEquals(smallTime, largeTime, 0);

    }

    @Test
    public void test_constantTime_for_enqueue() {
        RandomizedQueue largeN = largeQueue();

        Stopwatch stopwatch = new Stopwatch();
        largeN.enqueue(99);
        double largeTime = stopwatch.elapsedTime();


        RandomizedQueue smallN = smallQueue();

        stopwatch = new Stopwatch();
        smallN.enqueue(99);
        double smallTime = stopwatch.elapsedTime();

        assertEquals(smallTime, largeTime, 0);

    }

    @Test
    public void test_constantTime_for_dequeue() {
        RandomizedQueue largeN = largeQueue();

        Stopwatch stopwatch = new Stopwatch();
        largeN.dequeue();
        double largeTime = stopwatch.elapsedTime();


        RandomizedQueue smallN = smallQueue();

        stopwatch = new Stopwatch();
        smallN.dequeue();
        double smallTime = stopwatch.elapsedTime();

        assertEquals(smallTime, largeTime, 0);


    }

    @Test
    public void test_constantTime_for_sample() {
        RandomizedQueue testObj = new RandomizedQueue();
        testObj.sample();

    }

    public RandomizedQueue largeQueue() {
        RandomizedQueue largeN = new RandomizedQueue<Integer>();
        for (int i = 0; i < 10000000; i++) {
            largeN.enqueue(i);
        }
        return largeN;
    }

    public RandomizedQueue smallQueue() {
        RandomizedQueue smallN = new RandomizedQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            smallN.enqueue(i);
        }
        return smallN;
    }

}