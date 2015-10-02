import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class BoardTest extends TestCase {

    public void testDimension() throws Exception {

    }

    public void test_Hamming_doesntCountZeroBlock() throws Exception {

    }

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

    public void test_Hamming_solvedPuzzle() {
//        8  1  3        1  2  3     1  2  3  4  5  6  7  8
//        4     2        4  5  6     ----------------------
//        7  6  5        7  8        1  1  0  0  1  1  0  1

//        initial          goal         Hamming = 5 + 0

        int[][] solvedBlocks = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 0}
        };

        Board testObj = new Board(solvedBlocks);

        assertEquals(0, testObj.hamming());
    }

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

        assertEquals(5, testObj.manhattan());
    }

    public void testManhattan_solvedPuzzle() throws Exception {
//        8  1  3        1  2  3     1  2  3  4  5  6  7  8
//        4     2        4  5  6     ----------------------
//        7  6  5        7  8        1  2  0  0  2  2  0  3

//        initial          goal        Manhattan = 10 + 0
        int[][] solvedBlocks = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 0}
        };

        Board testObj = new Board(solvedBlocks);

        assertEquals(0, testObj.manhattan());
    }


    public void testIsGoal() throws Exception {

    }

    public void testTwin() throws Exception {

    }

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

    public void testNeighbors() throws Exception {

    }

    public void testToString() throws Exception {
        int[][] blocks = new int[][]{
                new int[]{1, 0, 3},
                new int[]{4, 2, 5},
                new int[]{7, 8, 6}
        };

        Board testObj = new Board(blocks);

        System.out.println(testObj);
        assertEquals("3\n 1  0  3 \n 4  2  5 \n 7  8  6 \n", testObj.toString());

    }


    @Test
    public void test_correctRow() {

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

            assertEquals(2, testObj.correctX(8));
            assertEquals(3, testObj.correctY(8));
        }

    public void testMain() throws Exception {

    }
}