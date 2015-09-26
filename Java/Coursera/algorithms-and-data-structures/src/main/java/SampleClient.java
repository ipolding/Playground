import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;


public class SampleClient {

    public static void main(String[] args) {

        Point[] points = contrivedPointArray();
        bruteTest(points);
        System.out.println("\n\n\n");
        fastTest(points);
        System.out.println("\n\n\n");

        bruteTest(manuallyCreatePointArray6());
        System.out.println("\n\n\n");
        fastTest(manuallyCreatePointArray6());
    }

    private static void bruteTest(Point[] points) {
        System.out.printf("*-*-*-*-*-*-*-*-*-*BRUTE TEST START %d Points*-*-*-*-*-*-*-*-*-*\n", points.length);
        // print and draw the line segments
        BruteCollinearPoints bruteCollinear = new BruteCollinearPoints(points);
        for (LineSegment segment : bruteCollinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        System.out.println("*-*-*-*-*-*-*-*-*-*BRUTE TEST FINISH *-*-*-*-*-*-*-*-*-*");
    }

    private static void fastTest(Point[] points) {
        System.out.printf("*-*-*-*-*-*-*-*-*-*FAST TEST START %d Points*-*-*-*-*-*-*-*-*-*\n", points.length);
        // print and draw the line segments
        FastCollinearPoints fastCollinear = new FastCollinearPoints(points);
        for (LineSegment segment : fastCollinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        System.out.println("*-*-*-*-*-*-*-*-*-*FAST TEST FINISH *-*-*-*-*-*-*-*-*-*");
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
                new Point(4, 4),
                new Point(1, 1),
                new Point(3, 3),
                new Point(2, 2)
        };
    }

    public static Point[] duplicatePoints() {
        return new Point[]{
                new Point(1, 1),
                new Point(3, 3),
                new Point(3, 3),
                new Point(0, 3),
                new Point(1, 4),
                new Point(2, 5),
                new Point(3, 6),
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

    public static Point[] manuallyCreatePointArray8() {
        return new Point[]{
                new Point(10000, 0),
                new Point(0, 10000),
                new Point(3000, 7000),
                new Point(7000, 3000),
                new Point(20000, 21000),
                new Point(3000, 4000),
                new Point(14000, 15000),
                new Point(6000, 7000)
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