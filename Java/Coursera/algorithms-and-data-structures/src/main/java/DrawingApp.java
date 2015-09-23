import edu.princeton.cs.algs4.StdDraw;

public class DrawingApp {
    public static void main(String[] args) {
        Point p = new Point(2,2);
        Point q = new Point(4,4);

        StdDraw.show(0);
        StdDraw.setXscale(0, 10);
        StdDraw.setYscale(0, 10);
        for (Point point : new Point[] {p, q}) {
            point.draw();

        }
        new LineSegment(p, q).draw();
        StdDraw.show();
    }

}