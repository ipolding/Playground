
// TODO You must use MinPQ for the priority queue(s).
import edu.princeton.cs.algs4.MinPQ;
//TODO You may not call any library functions other those in java.lang, java.util, and algs4.jar.
import java.util.*;
import java.lang.*;

/**
 *  A Binary search tree is made up of Nodes
 *  For this problem, each Node:
 *      * a board
 *      * the number of moves made to reach the board
 *      * the previous search node.
 *
 *  The Solution starts with a Priorty Queue with one board - the initial board, with no next board and 0 moves
 *
 *  1) Initialise the Queue
 *  2) Delete the minimum priority Node from the queue.
 *  3) Insert all neighbouring search nodes - those that can be reached in one move from the dequeued Node.
 *  4) Repeat until we have the dequeued the solution i.e. when the solution == the minumum.
 *
 *  THIS SOLUTION HINGES ON PRIORITY!!
 *      Hamming Priority == number of blocks in the wrong position + number of moves made to get there
 *      Small number of blocks in wrong position == Good; Fewer moves to get there == BETTER.
 *
 *      Manhattan Priority Function ==
 *          sum of the manhattan distances (sum of the vertical and horizontal distance) *
 *          from the blocks to their goal positions + number of moves *
 *
 *
 *
 * For example, the Hamming and Manhattan priorities of the initial search node below are 5 and 10, respectively.

    8  1  3        1  2  3     1  2  3  4  5  6  7  8    1  2  3  4  5  6  7  8
    4     2        4  5  6     ----------------------    ----------------------
    7  6  5        7  8        1  1  0  0  1  1  0  1    1  2  0  0  2  2  0  3

     initial          goal         Hamming = 5 + 0          Manhattan = 10 + 0

 Manhattan - position 1 is (1+0) away; position 2 is (1+1) away etc.
 Hamming - 3 correct; 4 correct; 7 correct; rest wrong so distance is 8 - 3 == 5.

 Smaller the ranking, the closer we are to the solution!! Hence we delete the minimum!!

 We dequeue the MINIMUM; the MINIMUM is the BEST; hence BEST-FIRST SEARCH.


 We make a key observation: the total number of moves we need to make (including those already made) >= its priority
 *
 *
 * CRITICAL OPTIMIZATION
 * Don't enqueue a neighbor if its board is the same as the board of the previous search node.
 *
 *
 *
 *
 * Game Tree
 *     View the problem as a 'game tree'. Each node in the tree is a game state.
 *     Root == initial gameboard
 *         Internal nodes have already been processed.
 *         Leaf nodes are maintained in a priority queue.
 *
 *         Removed nodes children are added to the game tree and the priority queue.
 *
 *
 *
 *
 *
 * */


public class Solver {

//    To implement the A* algorithm, you must use MinPQ from algs4.jar for the priority queue(s).
//
    public Solver(Board initial) {
    // find a solution to the initial board (using the A* algorithm)



    }

    public boolean isSolvable() {
    // is the initial board solvable?

        /**
         * Detecting unsolvable puzzles. Not all initial boards can lead to the goal board by a sequence of legal moves,
         * including the two below:

         1  2  3         1  2  3  4
         4  5  6         5  6  7  8
         8  7            9 10 11 12
                         13 15 14

         To detect such situations, use the fact that boards are divided into two equivalence classes with respect to
         reachability: (i) those that lead to the goal board and (ii) those that lead to the goal board if we modify
         the initial board by swapping any pair of blocks (the blank square is not a block).

         To apply the fact, alternate between running the A* algorithm on two puzzle instances
            -- one with the initial board
            -- and one with the initial board modified by swapping a pair of blocks.

         Exactly one of the two will lead to the goal board.
         *
         */
        return false;
    }

    public int moves() {
    // min number of moves to solve initial board; -1 if unsolvable
return 0;
    }

    public Iterable<Board> solution() {
    // sequence of boards in a shortest solution; null if unsolvable
    return null;
    }

    public static void main(String[] args) {
    // solve a slider puzzle (given below)

    }

}