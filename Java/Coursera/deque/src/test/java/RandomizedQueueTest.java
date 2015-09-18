import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.NoSuchElementException;

@RunWith(JUnit4.class)
public class RandomizedQueueTest extends TestCase {

    final boolean exceptionThrown = false;

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
        RandomizedQueue testObj = new RandomizedQueue();
        testObj.size();

    }

    @Test
    public void test_constantTime_for_enqueue() {
        RandomizedQueue testObj = new RandomizedQueue();
        testObj.enqueue(null);

    }

    @Test
    public void test_constantTime_for_dequeue() {
        RandomizedQueue testObj = new RandomizedQueue();
        testObj.dequeue();

    }

    @Test
    public void test_constantTime_for_sample() {
        RandomizedQueue testObj = new RandomizedQueue();
        testObj.sample();

    }

}