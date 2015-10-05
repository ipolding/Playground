package comparison.huang;/*
 *
 */
import comparison.DarwinBoard;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Stack;

/**
 *
 * @author Webber Huang
 */

public class Solver {
    private SearchNode result;

    // Search Node implementation
    private class SearchNode implements Comparable<SearchNode> {
        private final DarwinBoard DarwinBoard;
        private final SearchNode prev;
        private final int move, priority;

        public SearchNode(DarwinBoard DarwinBoard, SearchNode prev) {
            this.DarwinBoard = DarwinBoard;
            this.prev = prev;
            if (prev == null) move = 0;
            else move = prev.move + 1;
            priority = DarwinBoard.manhattan() + move;
        }

        public int compareTo(SearchNode that) {
            return this.priority - that.priority;
        }

        public boolean isGoal() {
            return DarwinBoard.isGoal();
        }

        public SearchNode twin() {
            return new SearchNode(DarwinBoard.twin(), prev);
        }
    }

    // find a solution to the initial DarwinBoard (using the A* algorithm)
    public Solver(DarwinBoard initial) {
        // run solver
        result = solveIt(new SearchNode(initial, null));
    }

    private SearchNode calculateOneStep(MinPQ<SearchNode> pq) {
        SearchNode least = pq.delMin();
        for (DarwinBoard neighbor : least.DarwinBoard.neighbors()) {
            if (least.prev == null || !neighbor.equals(least.prev.DarwinBoard))
                pq.insert(new SearchNode(neighbor, least));
        }
        return least;
    }

    private SearchNode solveIt(SearchNode initial) {
        SearchNode last = initial;
        MinPQ<SearchNode> solutionQueue = new MinPQ();
        solutionQueue.insert(last);

        MinPQ<SearchNode> twinQueue = new MinPQ();
        twinQueue.insert(initial.twin());

        while (true) {
            last = calculateOneStep(solutionQueue);
            if (last.isGoal()) return last;

            // solve twin search node
            if (calculateOneStep(twinQueue).isGoal()) return null;
        }
    }

    // is the initial DarwinBoard solvable?
    public boolean isSolvable() {
        return result != null;
    }

    // min number of moves to solve initial DarwinBoard; -1 if no solution
    public int moves() {
        if (isSolvable()) return result.move;
        return -1;
    }

    // sequence of DarwinBoards in a shortest solution; null if no solution
    public Iterable<DarwinBoard> solution() {
        if (!isSolvable()) return null;
        Stack<DarwinBoard> s = new Stack();
        for (SearchNode n = result; n != null; n = n.prev) {
            s.push(n.DarwinBoard);
        }
        return s;
    }

    // solve a slider puzzle (given below)
    public static void main(String[] args) {
        // create initial DarwinBoard from file
        In in = new In(args[0]);
        //String path = "E:/Coursera/Algorithms, Part I/Week 4/Assignment/8puzzle/src/puzzle34.txt";
        //In in = new In(path);
        int N = in.readInt();
        int[][] blocks = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                blocks[i][j] = in.readInt();
        DarwinBoard initial = new DarwinBoard(blocks);

        Stopwatch time1 = new Stopwatch();

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (DarwinBoard DarwinBoard : solver.solution())
                StdOut.println(DarwinBoard);
        }
        StdOut.println("Time escape:   " + time1.elapsedTime());
    }

}