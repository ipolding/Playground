import edu.princeton.cs.algs4.Stopwatch;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.instrument.Instrumentation;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
    public void test_dequeueNeverReturnsNull() {
        RandomizedQueue<Integer> tenStringQueue = new RandomizedQueue<Integer>();
        for(int i = 0; i <10; i++) {
            tenStringQueue.enqueue(i);
        }
        assertEquals(10, tenStringQueue.size());

        for (int i = 0; i < 10; i++) {
            assertNotNull(tenStringQueue.dequeue());
        }
        assertEquals(0, tenStringQueue.size());


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
    public void multipleDeQueue() {

        RandomizedQueue<Integer> largeN = largeQueue();

        for (int i = 0; i < 10; i++) {
            largeN.dequeue();
        }

    }


    @Test
    public void twoElementQ_whileDeque_AlwaysReturnsOneOfTwoElements() {
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
    public void twoElementQ_dequeue_AlwaysReturnsOneOfTwoElements() {
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
    public void test_iteratorCyclesThroughQ() {
        RandomizedQueue<Integer> queue = tenItemQueue();
        for (Integer i : queue) {
            System.out.println(i);
        }
    }

    @Test
    public void test_The_order_of_two_or_more_iterators_to_the_same_randomized_queue_must_be_mutually_independent() {

        RandomizedQueue<Integer> queue1 = tenItemQueue();

        StringBuilder iterator1Output = new StringBuilder();
        StringBuilder iterator1Output2 = new StringBuilder();

        for (Integer i : queue1) {
            iterator1Output.append(i + " ");
            for (Integer j : queue1) {
                iterator1Output2.append(j + " ");
            }
        }

        System.out.println(iterator1Output2.toString().substring(0, 20));
        System.out.println(iterator1Output.toString());
        assertFalse(iterator1Output.toString().equals(iterator1Output2.toString()));

    }

    @Test
    public void test_each_iterator_must_maintain_its_own_random_order() {

            RandomizedQueue<Integer> queue1 = tenItemQueue();

            StringBuilder iterator1Output = new StringBuilder();
            StringBuilder iterator1Output2 = new StringBuilder();

            for (Integer i : queue1) {
                iterator1Output.append(i + " ");
                for (Integer j : queue1) {
                    iterator1Output2.append(j + " ");
                }
            }

            System.out.println(iterator1Output2.toString().substring(0,20));
            System.out.println(iterator1Output.toString());
            assertFalse(iterator1Output.toString().equals(iterator1Output2.toString()));

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


        RandomizedQueue smallN = tenItemQueue();

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


        RandomizedQueue smallN = tenItemQueue();

        stopwatch = new Stopwatch();
        smallN.enqueue(99);
        double smallTime = stopwatch.elapsedTime();

        assertEquals(smallTime, largeTime, 0);

    }

    @Test
    public void test_constantTime_for_knownNull_dequeue() {
        RandomizedQueue largeN = largeQueue();

        Stopwatch stopwatch = new Stopwatch();
        largeN.dequeue();
        double largeTime = stopwatch.elapsedTime();


        RandomizedQueue smallN = tenItemQueue();

        stopwatch = new Stopwatch();
        smallN.dequeue();
        double smallTime = stopwatch.elapsedTime();

        assertEquals(smallTime, largeTime, 0);


    }

    @Test
    public void test_constantTime_for_sample() {
        RandomizedQueue largeN = largeQueue();

        Stopwatch stopwatch = new Stopwatch();
        largeN.sample();
        double largeTime = stopwatch.elapsedTime();


        RandomizedQueue smallN = tenItemQueue();

        stopwatch = new Stopwatch();
        smallN.sample();
        double smallTime = stopwatch.elapsedTime();

        assertEquals(smallTime, largeTime, 0);
    }

    public RandomizedQueue largeQueue() {
        RandomizedQueue largeN = new RandomizedQueue<Integer>();
        for (int i = 0; i < 1000000; i++) {
            largeN.enqueue(i);
        }
        return largeN;
    }

    public RandomizedQueue<Integer> tenItemQueue() {
        RandomizedQueue smallN = new RandomizedQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            smallN.enqueue(i);
        }
        return smallN;
    }

    public RandomizedQueue tenKQ() {
        RandomizedQueue smallN = new RandomizedQueue<Integer>();
        for (int i = 0; i < 10000; i++) {
            smallN.enqueue(i);
        }
        return smallN;
    }

}