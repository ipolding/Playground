
// TODO You must use MinPQ for the priority queue(s).

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;
//TODO You may not call any library functions other those in java.lang, java.util, and algs4.jar.
import java.util.*;
import java.lang.*;

/**
 * A Binary search tree is made up of Nodes
 * For this problem, each Node:
 * * a board
 * * the number of moves made to reach the board
 * * the previous search node.
 * <p/>
 * The Solution starts with a Priorty Queue with one board - the initial board, with no next board and 0 moves
 * <p/>
 * 1) Initialise the Queue
 * 2) Delete the minimum priority Node from the queue.
 * 3) Insert all neighbouring search nodes - those that can be reached in one move from the dequeued Node.
 * 4) Repeat until we have the dequeued the solution i.e. when the solution == the minumum.
 * <p/>
 * THIS SOLUTION HINGES ON PRIORITY!!
 * Hamming Priority == number of blocks in the wrong position + number of moves made to get there
 * Small number of blocks in wrong position == Good; Fewer moves to get there == BETTER.
 * <p/>
 * Manhattan Priority Function ==
 * sum of the manhattan distances (sum of the vertical and horizontal distance) *
 * from the blocks to their goal positions + number of moves *
 * <p/>
 * <p/>
 * <p/>
 * For example, the Hamming and Manhattan priorities of the initial search node below are 5 and 10, respectively.
 * <p/>
 * 8  1  3        1  2  3     1  2  3  4  5  6  7  8    1  2  3  4  5  6  7  8
 * 4     2        4  5  6     ----------------------    ----------------------
 * 7  6  5        7  8        1  1  0  0  1  1  0  1    1  2  0  0  2  2  0  3
 * <p/>
 * initial          goal         Hamming = 5 + 0          Manhattan = 10 + 0
 * <p/>
 * Manhattan - position 1 is (1+0) away; position 2 is (1+1) away etc.
 * Hamming - 3 correct; 4 correct; 7 correct; rest wrong so distance is 8 - 3 == 5.
 * <p/>
 * Smaller the ranking, the closer we are to the solution!! Hence we delete the minimum!!
 * <p/>
 * We dequeue the MINIMUM; the MINIMUM is the BEST; hence BEST-FIRST SEARCH.
 * <p/>
 * <p/>
 * We make a key observation: the total number of moves we need to make (including those already made) >= its priority
 * <p/>
 * <p/>
 * CRITICAL OPTIMIZATION
 * Don't enqueue a neighbor if its board is the same as the board of the previous search node.
 * <p/>
 * <p/>
 * <p/>
 * <p/>
 * Game Tree
 * View the problem as a 'game tree'. Each node in the tree is a game state.
 * Root == initial gameboard
 * Internal nodes have already been processed.
 * Leaf nodes are maintained in a priority queue.
 * <p/>
 * Removed nodes children are added to the game tree and the priority queue.
 */
public class Solver {

    private int solvedBoardMoves = 0;

    private final SearchNode solution;


    public static void main(String[] args) {

        // create initial board from file
        In in = new In(args[0]);
        int N = in.readInt();
        int[][] blocks = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }

    private final Board initial;

    public Solver(Board initial) {

        if (null == initial) {
            throw new NullPointerException();
        }
        this.initial = initial;

        if (isSolvable()) {
             solution = solve(initial, solvedBoardMoves);
        } else {
            solution = null;
        }



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
         -- one with the initial board*/

        /*-- and one with the initial board modified by swapping a pair of blocks.*/

        /* Exactly one of the two will lead to the goal board. */

        if (null !=  solve(initial.twin(), 0)) {
            return false;
        }
        return true;
    }

    public int moves() {
        if (solvedBoardMoves == 0) {
            return -1;
        }
        return solvedBoardMoves;
    }

    public Iterable<Board> solution() {
        // sequence of boards in a shortest solution; null if unsolvable
        System.out.println("Using linkedlist");
        return linkedListSolution();
    }

    private Iterable<Board> linkedListSolution() {
        LinkedList<Board> solutionBoards = new LinkedList<Board>();

//        Queue<Board> solutionBoards = Collections.asLifoQueue(new ArrayDeque());

        if (null == solution) {
            return solutionBoards;
        }
        SearchNode previousNode = solution.previousSearchNode;



        solutionBoards.add(solution.board);
        while (previousNode != null) {
            solutionBoards.addFirst(previousNode.board);
            previousNode = previousNode.previousSearchNode;
        }
//        Collections.reverse(solutionBoards);
        return solutionBoards;
    }

    private SearchNode solve(Board board, int moves) {

        boolean solved = false;

        MinPQ<SearchNode> minPQ = new MinPQ();

        SearchNode minimum = new SearchNode(board, 0, null);
        minPQ.insert(minimum);

//    *  2) Delete the minimum priority Node from the queue.
//    *  4) Repeat until we have the dequeued the solution i.e. when the solution == the minumum.
        for (int i = 0; i < minimum.board.dimension() * minimum.board.dimension(); i++) {
            if (minimum.getBoard().isGoal()) {
                solvedBoardMoves = moves;
                return minimum;
            }
//    *  3) Insert all neighbouring search nodes - those that can be reached in one move from the dequeued Node.
                moves++;
                for (Board neighbor : minimum.getBoard().neighbors()) {
                    SearchNode searchNode = new SearchNode(neighbor, moves, minimum);
                    if (null == minimum.previousSearchNode || !neighbor.equals(minimum.previousSearchNode.board)) {
                        minPQ.insert(searchNode);
                    }
                }
                minimum = minPQ.delMin();

        }
        return null;

    }


    /* <p><li> Write a nested class <tt>SearchNode</tt> that represents a search node */
    private class SearchNode implements Comparable<SearchNode> {

        private final Board board;
        private final Integer numberOfMovesToReachIt;
        private final SearchNode previousSearchNode;

        private SearchNode(Board board, int numberOfMovesToReachIt, SearchNode previousSearchNode) {
            this.board = board;
            this.numberOfMovesToReachIt = numberOfMovesToReachIt;
            this.previousSearchNode = previousSearchNode;
        }

        // The success of this approach hinges on the choice of priority function for a search node.
        public int compareTo(SearchNode that) {

// a search node with a small number of blocks in the wrong position is close to the goal,
// we prefer a search node that have been reached using a small number of moves.
            int hammingComparison = /*-1*/ (Integer.valueOf(board.hamming()).compareTo(that.board.manhattan()));
            if (hammingComparison == 0) {
                return /*-1*/ (this.numberOfMovesToReachIt.compareTo(that.numberOfMovesToReachIt));
            } else {
                return hammingComparison;
            }
        }

        public Board getBoard() {
            return board;
        }
    }

}