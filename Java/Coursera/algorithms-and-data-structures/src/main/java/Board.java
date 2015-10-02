// TODO You must use MinPQ for the priority queue(s).
import edu.princeton.cs.algs4.MinPQ;
//TODO You may not call any library functions other those in java.lang, java.util, and algs4.jar.
import java.util.*;
import java.lang.*;

public class Board {
    public Board(int[][] blocks) {
        // construct a board from an N-by-N array of blocks
        // (where blocks[i][j] = block in row i, column j)

        // You may assume that the constructor receives an N-by-N array containing the N2 integers between
        // 0 and N2 − 1, where 0 represents the blank square.


    }

    //TODO Performance requirements: all Board methods in time proportional to N2 (or better)


    public int dimension() {// board dimension N
        return 0;
    }

    public int hamming() {// number of blocks out of place
        return 0;
    }

    public int manhattan() {// sum of manhattan distances between blocks and goal
        return 0;
    }

    public boolean isGoal() {// is this board the goal board?
        return false;
    }

    public Board twin() {// a board that is obtained by exchanging any pair of blocks
        return null;
    }

    @Override
    public boolean equals(Object y) {// does this board equal y?
        return false;
    }

    public Iterable<Board> neighbors() {// all neighboring boards
        return null;
    }

    @Override
    public String toString() {// string representation of this board (in the output format specified below)
    return null;
    }

    public static void main(String[] args) {// unit tests (not graded)
    }

}