import junit.framework.TestCase;

public class BoardTest extends TestCase {

    public void testDimension() throws Exception {

    }

    public void test_Hamming_doesntCountZeroBlock() throws Exception {

    }

    public void test_Manhattan_doesntCountZeroBlock() throws Exception {

    }

    public void test_Hamming() {
//        8  1  3        1  2  3     1  2  3  4  5  6  7  8
//        4     2        4  5  6     ----------------------
//        7  6  5        7  8        1  1  0  0  1  1  0  1

//        initial          goal         Hamming = 5 + 0

        Board testObj = new Board(new int[][]{new int[]{}});

        assertEquals(5, testObj.hamming());
    }

    public void testManhattan() throws Exception {
//        8  1  3        1  2  3     1  2  3  4  5  6  7  8
//        4     2        4  5  6     ----------------------
//        7  6  5        7  8        1  2  0  0  2  2  0  3

//        initial          goal        Manhattan = 10 + 0
        Board testObj = new Board(new int[][]{new int[]{}});

        assertEquals(5, testObj.manhattan());
    }

    public void testIsGoal() throws Exception {

    }

    public void testTwin() throws Exception {

    }

    public void testEquals() throws Exception {

    }

    public void testNeighbors() throws Exception {

    }

    public void testToString() throws Exception {

    }

    public void testMain() throws Exception {

    }
}