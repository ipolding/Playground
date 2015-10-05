package comparison;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

public class DarwinSolver {
    //	  public Solver(DarwinBoard initial)            // find a solution to the initial DarwinBoard (using the A* algorithm)
//    public boolean isSolvable()             // is the initial DarwinBoard solvable?
//    public int moves()                      // min number of moves to solve initial DarwinBoard; -1 if no solution
//    public Iterable<DarwinBoard> solution()       // sequence of DarwinBoards in a shortest solution; null if no solution
//    public static void main(String[] args)  // solve a slider puzzle (given below)
    private boolean solvable=true;
    private int moves=0;
    private DarwinBoardContainter finalDarwinBoard=null;
    private DarwinBoard[] steps;
    private class DarwinBoardComparator implements Comparator<DarwinBoardContainter>{
        @Override
        public int compare(DarwinBoardContainter o1, DarwinBoardContainter o2) {
            if (o1.assesment()>o2.assesment()) {
                return 1;
            }else if (o1.assesment()<o2.assesment()) {
                return -1;
            }else{
                return 0;
            }
        }
    }
    private class DarwinBoardContainter{
        private DarwinBoard DarwinBoard;
        private int stepMoved;
        private DarwinBoardContainter rootDarwinBoardContainter;
        public DarwinBoardContainter(int stepMoved, DarwinBoard DarwinBoard,DarwinBoardContainter root) {
            this.stepMoved=stepMoved;
            this.DarwinBoard=DarwinBoard;
            this.rootDarwinBoardContainter=root;
        }
        public int assesment() {
            return stepMoved+DarwinBoard.manhattan();
        }
        public DarwinBoard getDarwinBoard() {
            return DarwinBoard;
        }
        public int getStepMoved() {
            return stepMoved;
        }
        public DarwinBoardContainter getRootDarwinBoardContainter() {
            return rootDarwinBoardContainter;
        }
    }
    public DarwinSolver(DarwinBoard initial){
        AstarAlgorithm(initial);
    }
    private void AstarAlgorithm(DarwinBoard initial){
        MinPQ<DarwinBoardContainter> statusQueue1=new MinPQ<DarwinBoardContainter>(new DarwinBoardComparator());
        MinPQ<DarwinBoardContainter> statusQueue2=new MinPQ<DarwinBoardContainter>(new DarwinBoardComparator());
        DarwinBoardContainter currDarwinBoard1=new DarwinBoardContainter(0, initial, null);
        DarwinBoardContainter currDarwinBoard2=new DarwinBoardContainter(0, initial.twin(), null);
        DarwinBoard previousDarwinBoard1=null;
        DarwinBoard previousDarwinBoard2=null;
        while (true) {
            if (currDarwinBoard1.getDarwinBoard().isGoal()) {
                finalDarwinBoard=currDarwinBoard1;
                solvable=true;
                break;
            }
            if (currDarwinBoard2.getDarwinBoard().isGoal()) {
                solvable=false;
                break;
            }
            try {
                previousDarwinBoard1=currDarwinBoard1.getRootDarwinBoardContainter().getDarwinBoard();
                previousDarwinBoard2=currDarwinBoard2.getRootDarwinBoardContainter().getDarwinBoard();
            } catch (Exception e) {
            }
            for (DarwinBoard DarwinBoard : currDarwinBoard1.getDarwinBoard().neighbors()) {
                if (!DarwinBoard.equals(previousDarwinBoard1)) {
                    statusQueue1.insert(new DarwinBoardContainter(currDarwinBoard1.getStepMoved()+1, DarwinBoard, currDarwinBoard1));
                }
            }
            for (DarwinBoard DarwinBoard : currDarwinBoard2.getDarwinBoard().neighbors()) {
                if (!DarwinBoard.equals(previousDarwinBoard2)) {
                    statusQueue2.insert(new DarwinBoardContainter(currDarwinBoard2.getStepMoved()+1, DarwinBoard,currDarwinBoard1));
                }
            }
            currDarwinBoard1=statusQueue1.delMin();
            currDarwinBoard2=statusQueue2.delMin();
            moves=currDarwinBoard1.getStepMoved();
        }
        steps=new DarwinBoard[moves+1];
        for (DarwinBoardContainter DarwinBoardContainter=finalDarwinBoard; DarwinBoardContainter!=null; DarwinBoardContainter=DarwinBoardContainter.getRootDarwinBoardContainter()) {
            steps[DarwinBoardContainter.getStepMoved()]=DarwinBoardContainter.getDarwinBoard();
        }
    }
    public int moves(){
        if (!solvable) {
            return -1;
        }
        return moves;
    }
    public Iterable<DarwinBoard> solution(){
        if (!solvable) {
            return null;
        }
        return Arrays.asList(steps);
    }
    public boolean isSolvable() {
        return solvable;
    }
    public static void main(String[] args){
        // create initial DarwinBoard from file
        //In in = new In(args[0]);
        int N = StdIn.readInt();
        int[][] blocks = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                blocks[i][j] = StdIn.readInt();
        DarwinBoard initial = new DarwinBoard(blocks);

        // solve the puzzle
        DarwinSolver solver = new DarwinSolver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (DarwinBoard DarwinBoard : solver.solution())
                StdOut.println(DarwinBoard);
        }
    }
}