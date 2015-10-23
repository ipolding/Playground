package comparison.huang;

/*
 *
 */

import edu.princeton.cs.algs4.*;

import java.util.Stack;

/*
 *
 */

/**
 *
 * @author Webber Huang
 */

import java.util.Arrays;

public class Board {
    private final char[] tiles;
    private int N, mht;

    // construct a board from an N-by-N array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks) {
        tiles = copy2DArrayTo1DChar(blocks);
        N = blocks.length;
        cachedManhattan();
    }

    // board dimension N
    public int dimension() {
        return N;
    }

    private void cachedManhattan() {
        int count = 0;
        for (int i = 0; i < N*N; i++) {
            int v = tiles[i];
            if (v != 0) {
                int step = Math.abs(i / N - (v-1) / N)
                        + Math.abs(i % N - (v-1) % N);
                count += step;
            }
        }
        mht = count;
    }

    // number of blocks out of place
    public int hamming() {
        int count = 0;
        for (int i = 0; i < N*N; i++) {
            int v = tiles[i];
            if (v != 0 && v != i + 1)
                count++;
        }
        return count;
    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
        return mht;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return hamming() == 0;
    }

    // a board obtained by exchanging two adjacent blocks in the same row
    public Board twin()  {
        int random = StdRandom.uniform(N*N);
        int i = random / N;
        int j = random % N;

        if (tiles[random] != 0
                && j+1 != N
                && tiles[i*N + j + 1] != 0) {
            // swap two ajacent blocks
            int[][] twTiles = copy1DCharTo2DArray(tiles);
            int swap = twTiles[i][j];
            twTiles[i][j] = twTiles[i][j+1];
            twTiles[i][j+1] = swap;

            return new Board(twTiles);
        }
        else return twin();
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass())
            return false;

        Board that = (Board) y;
        return Arrays.equals(this.tiles, that.tiles);
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        // search blank block position
        int i = 0, j = 0;
        for (int k = 0; k < N*N; k++) {
            if (tiles[k] == 0) {
                i = k / N;
                j = k % N;
                break;
            }
        }

        // enqueue neighbors
        Queue<Board> queue = new Queue();
        if (i-1 >= 0) queue.enqueue(upNeighbor(i, j));
        if (i+1 < N) queue.enqueue(downNeighbor(i, j));
        if (j-1 >= 0) queue.enqueue(leftNeighbor(i, j));
        if (j+1 < N) queue.enqueue(rightNeighbor(i, j));
        return queue;
    }

    // string representation of the board (in the output format specified below)
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(N + "\n");
        for (int i = 0; i < N*N; i++) {
            s.append(String.format("%1d ", (int) tiles[i]));
            if ((i + 1) % N == 0)
                s.append("\n");
        }
        return s.toString();
    }

    /*    Hepler Methods    */
    private Board upNeighbor(int i, int j) {
        int[][] ngbTiles = copy1DCharTo2DArray(tiles);
        ngbTiles[i][j] = ngbTiles[i-1][j];
        ngbTiles[i-1][j] = 0;
        return new Board(ngbTiles);
    }

    private Board downNeighbor(int i, int j) {
        int[][] ngbTiles = copy1DCharTo2DArray(tiles);
        ngbTiles[i][j] = ngbTiles[i+1][j];
        ngbTiles[i+1][j] = 0;
        return new Board(ngbTiles);
    }

    private Board leftNeighbor(int i, int j) {
        int[][] ngbTiles = copy1DCharTo2DArray(tiles);
        ngbTiles[i][j] = ngbTiles[i][j-1];
        ngbTiles[i][j-1] = 0;
        return new Board(ngbTiles);
    }

    private Board rightNeighbor(int i, int j) {
        int[][] ngbTiles = copy1DCharTo2DArray(tiles);
        ngbTiles[i][j] = ngbTiles[i][j+1];
        ngbTiles[i][j+1] = 0;
        return new Board(ngbTiles);
    }

    private static char[] copy2DArrayTo1DChar(int[][] src) {
        int length = src.length;
        char[] tgt = new char[length*length];

        for (int i = 0; i < length*length; i++)
            tgt[i] = (char) src[i / length][i % length];

        return tgt;
    }

    private static int[][] copy1DCharTo2DArray(char[] src) {
        int length = src.length;
        int dimension = (int) Math.sqrt(length);
        int[][] tgt = new int[dimension][dimension];

        for (int i = 0; i < length; i++)
            tgt[i / dimension][i % dimension] = (int) src[i];

        return tgt;
    }
}