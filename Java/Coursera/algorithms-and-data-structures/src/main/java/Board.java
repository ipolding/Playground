// TODO You must use MinPQ for the priority queue(s).
//TODO You may not call any library functions other those in java.lang, java.util, and algs4.jar.

import java.util.*;
import java.lang.*;

public class Board {

    private static final int BLANK_BLOCK = 0;
    private final ArrayList<ArrayList<Integer>> columns;
    private final ArrayList<ArrayList<Integer>> solutionColumns;
    private final int N;


    public Board(int[][] blocks) {

        ArrayList<ArrayList<Integer>> columnList = new ArrayList();

        for (int[] inputColumn : blocks) {
            ArrayList<Integer> column = new ArrayList();
            int i = 0;
            for (int block : inputColumn) {
//                column[i++] = block;
                column.add(block);
            }
            columnList.add(column);
        }
        columns = columnList;

        // construct a board from an N-by-N array of blocks
        // (where blocks[i][j] = block in row i, column j)

        // You may assume that the constructor receives an N-by-N array containing the N2 integers between
        // 0 and N2 − 1, where 0 represents the blank square.
        N = blocks.length;

        solutionColumns = new ArrayList<ArrayList<Integer>>();
        int block = 1;
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> solvedColumn = new ArrayList();
            for (int j = 0; j < N; j++) {

                if (block < N * N) {
                    solvedColumn.add(block++);
                } else {
                    solvedColumn.add(BLANK_BLOCK);
                }
            }
            solutionColumns.add(solvedColumn);



        /*
        1  2  3
        4  5  6
        7  8
         goal
         */

        }

        System.out.println(solutionColumns);
        System.out.println(columns);
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
                final int solutionBlock = solutionColumns.get(i).get(j);
                final int currentBlock = columns.get(i).get(j);


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
            //TODO what is the correct column !?
            for (int row = 0; row < N; row++) {
                final int currentBlock = columns.get(column).get(row);
                correctY(currentBlock);

                int rowOffset = Math.abs(row - correctX(currentBlock));
                int columnOffset = Math.abs(column - correctY(currentBlock));

                //value minus 1 gives array position.
                final int solutionBlock = solutionColumns.get(column).get(row);

                int currentArrayPosition = currentBlock - 1;

                if (currentBlock != solutionBlock) {
                    manhattanSums += rowOffset;
                    manhattanSums += columnOffset;
                }
            }
        }
        return manhattanSums;
    }

    //TODO DO NOT SUBMIT AS PUBLIC!!!!!!!!!
    public int correctY(int currentBlock) {
//        return (currentBlock / N) - 1;
        return (int) Math.sqrt(currentBlock)-1;
    }

    //TODO DO NOT SUBMIT AS PUBLIC!!!!!!!!!
    public int correctX(int currentBlock) {
//        return (currentBlock / N) - 1;
        return (int) Math.sqrt(currentBlock);
    }

    public boolean isGoal() {// is this board the goal board?
        return false;
    }

    public Board twin() {// a board that is obtained by exchanging any pair of blocks
        return null;
    }

    @Override
    public boolean equals(Object y) {// does this board equal y?

        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        Board that = (Board) y;

        return (this.N == that.N && this.columns.equals(that.columns));

//        return (this.month == that.month) && (this.day == that.day) && (this.year == that.year);



    /*Java has some arcane rules for implementing equals(), discussed on p. 103 of Algorithms, 4th edition. Note that the argument to equals() is required to be Object. */

    }

    public Iterable<Board> neighbors() {// all neighboring boards
        /*
        * Add the items you want to a Stack<Board> or Queue<Board> and return that.
        * */
        return null;
    }

    @Override
    public String toString() {// string representation of this board (in the output format specified below)
        //TODO implement the toString() method for Board exactly as specified
        StringBuilder sb = new StringBuilder();
        sb.append(dimension() + "\n");
        for (ArrayList<Integer> column : columns) {
            for (int block : column) {
                sb.append(String.format("%2d ", block));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {// unit tests (not graded)
    }
}