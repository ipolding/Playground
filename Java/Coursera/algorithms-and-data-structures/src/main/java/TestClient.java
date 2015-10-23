import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ian.polding on 02/10/2015.
 */
public class TestClient {

    /**Solver test client.
     * Use the following test client to read a puzzle from a file (specified as a command-line argument)
     * and print the solution to standard output.
     */

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

/**
 * Input and output formats. The input and output format for a board is the board dimension N followed by the N-by-N initial board, using 0 to represent the blank square. As an example,

 % more puzzle04.txt
 3
 0  1  3
 4  2  5
 7  8  6

 % java Solver puzzle04.txt
 Minimum number of moves = 4

 3
 0  1  3
 4  2  5
 7  8  6

 3
 1  0  3
 4  2  5
 7  8  6

 3
 1  2  3
 4  0  5
 7  8  6

 3
 1  2  3
 4  5  0
 7  8  6

 3
 1  2  3
 4  5  6
 7  8  0
 % more puzzle3x3-unsolvable.txt
 3
 1  2  3
 4  5  6
 8  7  0

 % java Solver puzzle3x3-unsolvable.txt
 No solution possible
 *
 * */

}
