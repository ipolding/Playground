import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class BoardTest extends TestCase {

    final int[][] solvedBlocks = new int[][]{
            new int[]{1, 2, 3},
            new int[]{4, 5, 6},
            new int[]{7, 8, 0}
    };

    @Test
    public void testDimension() throws Exception {

    }

    @Test
    public void test_Hamming_doesntCountZeroBlock() throws Exception {

    }

    @Test
    public void test_Manhattan_doesntCountZeroBlock() throws Exception {

    }

    public void test_Hamming_unsolvedPuzzle() {
//        8  1  3        1  2  3     1  2  3  4  5  6  7  8
//        4     2        4  5  6     ----------------------
//        7  6  5        7  8        1  1  0  0  1  1  0  1

//        initial          goal         Hamming = 5 + 0

        int[][] blocks = new int[][]{
                new int[]{8, 1, 3},
                new int[]{4, 0, 2},
                new int[]{7, 6, 5}
        };

        Board testObj = new Board(blocks);

        assertEquals(5, testObj.hamming());
    }

    @Test
    public void test_Hamming_solvedPuzzle() {
//        8  1  3        1  2  3     1  2  3  4  5  6  7  8
//        4     2        4  5  6     ----------------------
//        7  6  5        7  8        1  1  0  0  1  1  0  1

//        initial          goal         Hamming = 5 + 0

        Board testObj = new Board(solvedBlocks);
        assertTrue(testObj.isGoal());
        assertEquals(0, testObj.hamming());
    }

    @Test
    public void testManhattan() throws Exception {
//        8  1  3        1  2  3     1  2  3  4  5  6  7  8
//        4     2        4  5  6     ----------------------
//        7  6  5        7  8        1  2  0  0  2  2  0  3

//        initial          goal        Manhattan = 10 + 0
        int[][] blocks = new int[][]{
                new int[]{8, 1, 3},
                new int[]{4, 0, 2},
                new int[]{7, 6, 5}
        };

        Board testObj = new Board(blocks);

        assertEquals(10, testObj.manhattan());
    }

    @Test
    public void testManhattan_solvedPuzzle() throws Exception {
//        8  1  3        1  2  3     1  2  3  4  5  6  7  8
//        4     2        4  5  6     ----------------------
//        7  6  5        7  8        1  2  0  0  2  2  0  3

//        initial          goal        Manhattan = 10 + 0

        Board testObj = new Board(solvedBlocks);

        assertEquals(0, testObj.manhattan());
    }

    @Test
    public void testIsGoal() throws Exception {

    }

    @Test
    public void test_twin_createsAnBoardWithTwoNonZeroBlocksSwapped() throws Exception {

        Board testObj = new Board(solvedBlocks);
        Board twin = testObj.twin();

        System.out.println(twin);
        System.out.println(testObj);
    }

    @Test
    public void testEquals() throws Exception {

    }

    @Test
    public void testEquals_isReflexive() throws Exception {

        int[][] blocks = new int[][]{
                new int[]{0, 1, 2},
                new int[]{3, 4, 5},
                new int[]{6, 7, 8}
        };

        Board testObj = new Board(blocks);
        assertEquals(testObj, testObj);
    }

    @Test
    public void testEquals_isSymmetrical_truePositive() throws Exception {
        int[][] blocks_1 = new int[][]{
                new int[]{0, 1, 2},
                new int[]{3, 4, 5},
                new int[]{6, 7, 8}
        };

        Board testObj_1 = new Board(blocks_1);
        Board testObj_2 = new Board(blocks_1);
        assertEquals(testObj_1, testObj_2);
        assertEquals(testObj_2, testObj_1);

    }

    @Test
    public void testEquals_isSymmetrical_trueNegative() throws Exception {
        int[][] blocks_1 = new int[][]{
                new int[]{0, 1, 2},
                new int[]{3, 4, 5},
                new int[]{6, 7, 8}
        };

        int[][] blocks_2 = new int[][]{
                new int[]{0, 6, 2},
                new int[]{3, 4, 1},
                new int[]{6, 7, 8}
        };

        Board testObj_1 = new Board(blocks_1);
        Board testObj_2 = new Board(blocks_2);
        assertNotEquals(testObj_1, testObj_2);
        assertNotEquals(testObj_2, testObj_1);

        }

    @Test
    public void testEquals_isTransitive() throws Exception {

        int[][] blocks_1 = new int[][]{
                new int[]{0, 1, 2},
                new int[]{3, 4, 5},
                new int[]{6, 7, 8}
        };

        Board testObj_1 = new Board(blocks_1);
        Board testObj_2 = new Board(blocks_1);
        Board testObj_3 = new Board(blocks_1);
        assertEquals(testObj_1, testObj_2);
        assertEquals(testObj_2, testObj_3);
        assertEquals(testObj_1, testObj_3);
    }

    @Test
    public void testNeighbors() throws Exception {
        int[][] blocks_awkward = new int[][]{
                new int[]{8, 1, 3},
                new int[]{4, 2, 5},
                new int[]{0, 6, 7}
        };

        Board testObj = new Board(blocks_awkward);
        System.out.println(testObj);
        System.out.println(testObj.neighbors());


    }

    @Test
    public void testToString() throws Exception {
        int[][] blocks = new int[][]{
                new int[]{1, 0, 3},
                new int[]{4, 2, 5},
                new int[]{7, 8, 6}
        };

        Board testObj = new Board(blocks);

        System.out.println(testObj);
        assertEquals("3\n 1  0  3 \n 4  2  5 \n 7  8  6 \n", testObj.toString());



//        8  1  3        1  2  3     1  2  3  4  5  6  7  8
//        4     2        4  5  6     ----------------------
//        7  6  5        7  8        1  2  0  0  2  2  0  3

//        initial          goal        Manhattan = 10 + 0
        int[][] blocks_awkward = new int[][]{
                new int[]{8, 1, 3},
                new int[]{4, 0, 5},
                new int[]{7, 6, 2}
        };

        System.out.println(new Board(blocks_awkward));

    }


    @Test
    public void test_convertToOneDimension() {

//        8  1  3        1  2  3     1  2  3  4  5  6  7  8
//        4     2        4  5  6     ----------------------
//        7  6  5        7  8        1  2  0  0  2  2  0  3

//        initial          goal        Manhattan = 10 + 0
        int[][] blocks = new int[][]{
                new int[]{8, 1, 3},
                new int[]{4, 0, 2},
                new int[]{7, 6, 5}
        };

        Board testObj = new Board(blocks);

//        assertEquals(1, testObj.convertToOneDimension(0, 0));
//        assertEquals(2, testObj.convertToOneDimension(0, 1));
//        assertEquals(3, testObj.convertToOneDimension(0, 2));
//        assertEquals(4, testObj.convertToOneDimension(1, 0));
//        assertEquals(5, testObj.convertToOneDimension(1, 1));
//        assertEquals(6, testObj.convertToOneDimension(1, 2));
//        assertEquals(7, testObj.convertToOneDimension(2, 0));
//        assertEquals(8, testObj.convertToOneDimension(2, 1));
//        assertEquals(9, testObj.convertToOneDimension(2, 2));
    }

    @Test
    public void test_findManhattanDistance() {

//        8  1  3        1  2  3     1  2  3  4  5  6  7  8
//        4     2        4  5  6     ----------------------
//        7  6  5        7  8        1  2  0  0  2  2  0  3

//        initial          goal        Manhattan = 10 + 0
        int[][] blocks = new int[][]{
                new int[]{8, 1, 3},
                new int[]{4, 0, 2},
                new int[]{7, 6, 5}
        };

        Board testObj = new Board(blocks);

    //    assertEquals(2, testObj.manhattanDistance(8, 6));
    //    assertEquals(1, testObj.manhattanDistance(2, 1));
    //    assertEquals(2, testObj.manhattanDistance(6, 2));
    //    assertEquals(0, testObj.manhattanDistance(3, 3));
    //    assertEquals(0, testObj.manhattanDistance(4, 4));
    //    assertEquals(2, testObj.manhattanDistance(9, 5));
    //    assertEquals(0, testObj.manhattanDistance(7, 7));
    //    assertEquals(3, testObj.manhattanDistance(1, 8));
    }

    public void testMain() throws Exception {

    }


}