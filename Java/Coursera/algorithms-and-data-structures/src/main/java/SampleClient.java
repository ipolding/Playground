import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;


public class SampleClient {

    public static void main(String[] args) {
        Point[] points = contrivedPointArray();
        drawPoints(points);

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }

    }

    private static void drawPoints(Point[] points) {
        // draw the points
        StdDraw.show(0);
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();
    }

    public static Point[] contrivedPointArray() {
        return new Point[]{
                new Point(0, 0),
                new Point(1, 1),
                new Point(2, 2),
                new Point(3, 3),
                new Point(4, 4),
        };
    }


    public static Point[] manuallyCreatePointArray6() {
        //input 6 point array
        return new Point[]{
                new Point(19000, 10000),
                new Point(18000, 10000),
                new Point(32000, 10000),
                new Point(21000, 10000),
                new Point(1234, 5678),
                new Point(14000, 10000)
        };
    }

    public static Point[] readPointArrayFromFile(String[] args) {

        // read the N points from a file
        In in = new In(args[0]);
        int N = in.readInt();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        return points;

    }

}