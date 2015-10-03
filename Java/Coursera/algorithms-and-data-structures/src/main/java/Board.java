// TODO You must use MinPQ for the priority queue(s).
//TODO You may not call any library functions other those in java.lang, java.util, and algs4.jar.

import java.util.*;
import java.lang.*;

public class Board {

    private static final int BLANK_BLOCK = 0;
    private final int[][] columns;
    private final int[][] solutionColumns;
    private final int N;

    private int zeroRow;
    private int zeroColumn;


    public Board(int[][] blocks) {

        ArrayList<ArrayList<Integer>> columnList = new ArrayList();

        // You may assume that the constructor receives an N-by-N array containing the N2 integers between
        // 0 and N2 − 1, where 0 represents the blank square.
        N = blocks.length;

        // construct a board from an N-by-N array of blocks
        // (where blocks[i][j] = block in row i, column j)
        columns = blocks;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (blocks[i][j] == 0) {
                    zeroRow = i;
                    zeroColumn = j;
                }
            }
        }


        solutionColumns = new int[N][N];//new ArrayList<ArrayList<Integer>>();
        int block = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (block < N * N) {
                    solutionColumns[i][j] = block++;// solvedColumn.add(block++);
                } else {
                    solutionColumns[i][j] = BLANK_BLOCK;
                }
            }
        }
    }

    //TODO Performance requirements: all Board methods in time proportional to N2 (or better)
    public int dimension() {// board dimension N
        return N;
    }

    public int hamming() {// number of blocks out of place
        int misplacedBlocks = 0;
        //TODO  hamming() should return the number of blocks out of position
        //TODO Recall that the blank square is not considered a block.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                final int solutionBlock = solutionColumns[i][j];//.get(i).get(j);
                final int currentBlock = columns[i][j];//.get(i).get(j);

                if (solutionBlock != currentBlock && 0 != currentBlock) {
                    misplacedBlocks++;
                }
            }
        }
        return misplacedBlocks;
    }

    public int manhattan() {// sum of manhattan distances between blocks and goal
        //TODO  manhattan() should return the sum of the Manhattan distances between the blocks and their goal positions.
        // TODO Recall that the blank square is not considered a block.
        int manhattanSums = 0;
        for (int column = 0; column < N; column++) {
            for (int row = 0; row < N; row++) {
                final int currentBlock = columns[column][row];//.get(column).get(row);

                if (currentBlock != 0) {
                    int current1DPosition = convertToOneDimension(row, column);
                    int manhattanDistance = manhattanDistance(current1DPosition, currentBlock);
                    manhattanSums += manhattanDistance;
                }
            }
        }
        return manhattanSums;
    }

    public boolean isGoal() {// is this board the goal board?
        return Arrays.deepEquals(columns, solutionColumns);
    }

    public Board twin() {// a board that is obtained by exchanging any pair of blocks
        /*todo You will use it to determine whether a puzzle is solvable:
        /* exactly one of a board and its twin are solvable.

        For example, here is a board and several possible twins. Your solver will use only one twin.
         */

        int[][] twinColumnsArray = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int currentBlock = columns[i][j];//.get(i).get(j);
                twinColumnsArray[i][j] = currentBlock;

            }
        }
        // A twin is obtained by swapping any pair of blocks (the blank square is not a block).

        int first = twinColumnsArray[0][0];
        int second = twinColumnsArray[0][1];

        if (first == 0) {
            first = twinColumnsArray[1][0];
            twinColumnsArray[1][0] = second;
            twinColumnsArray[0][1] = first;
        } else if (second == 0) {
            second = twinColumnsArray[1][1];
            twinColumnsArray[0][0] = second;
            twinColumnsArray[1][1] = first;
        } else {
            twinColumnsArray[0][0] = second;
            twinColumnsArray[0][1] = first;
        }

        Board twin = new Board(twinColumnsArray);

        return twin;
    }

    @Override
    public boolean equals(Object y) {// does this board equal y?
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        final Board that = (Board) y;
        return (this.N == that.N && Arrays.equals(this.columns, that.columns));
    }

    public Iterable<Board> neighbors() {// all neighboring boards
        /*
        * Add the items you want to a Stack<Board> or Queue<Board> and return that.
        * */
        Stack<Board> neighbors = new Stack<Board>();
        addNeighbors(neighbors);
        //You are permitted to slide blocks horizontally or vertically into the blank square.
        return neighbors;
    }

    private void addNeighbors(Stack<Board> neighbors) {

        int rowUp = zeroRow - 1;
        int rowDown = zeroRow + 1;
        int columnLeft = zeroColumn - 1;
        int columnRight = zeroColumn + 1;

        if (rowUp >= 0 && rowUp < N) {
            int[][] neighborBoard = copyBoard();
            int temp = neighborBoard[rowUp][zeroColumn];
            neighborBoard[rowUp][zeroColumn] = neighborBoard[zeroRow][zeroColumn];
            neighborBoard[zeroRow][zeroColumn] = temp;
            neighbors.add(new Board(neighborBoard));
        }

        if (rowDown >= 0 && rowDown < N) {
            int[][] neighborBoard = copyBoard();
            int temp = neighborBoard[rowDown][zeroColumn];
            neighborBoard[rowDown][zeroColumn] = neighborBoard[zeroRow][zeroColumn];
            neighborBoard[zeroRow][zeroColumn] = temp;
            neighbors.add(new Board(neighborBoard));
        }

        if (columnLeft >= 0 && columnLeft < N) {
            int[][] neighborBoard = copyBoard();
            int temp = neighborBoard[zeroRow][columnLeft];
            neighborBoard[zeroRow][columnLeft] = neighborBoard[zeroRow][zeroColumn];
            neighborBoard[zeroRow][zeroColumn] = temp;
            neighbors.add(new Board(neighborBoard));
        }

        if (columnRight >= 0 && columnRight < N) {
            int[][] neighborBoard = copyBoard();
            int temp = neighborBoard[zeroRow][columnRight];
            neighborBoard[zeroRow][columnRight] = neighborBoard[zeroRow][zeroColumn];
            neighborBoard[zeroRow][zeroColumn] = temp;
            neighbors.add(new Board(neighborBoard));
        }
    }

    private int[][] copyBoard() {
        int[][] neighbour = new int[columns.length][columns[0].length];
        for (int i = 0; i < neighbour.length; i++)
            neighbour[i] = Arrays.copyOf(columns[i], columns[i].length);
        return neighbour;
    }

    @Override
    public String toString() {// string representation of this board (in the output format specified below)
        StringBuilder sb = new StringBuilder();
        sb.append(dimension() + "\n");
        for (int i = 0; i < N; i++) { //ArrayList<Integer> column : columns) {
            for (int j = 0; j < N; j++) {
                sb.append(String.format("%2d ", columns[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private int convertToOneDimension(int column, int row) {
        return (row * N) + column + 1;
    }

    private int manhattanDistance(int current, int expected) {
        int distance = Math.abs(current - expected);
        int manhattan = distance / N + distance % 3;
        return manhattan;
    }

    public static void main(String[] args) {// unit tests (not graded)
    }
}