import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {

    private ArrayList<LineSegment> lineSegmentList = new ArrayList();

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {

        Arrays.sort(points);

        //Think of p as the origin.
        for (Point p : points) {
            int consecutivePoints = 0;
            //For each other point q, determine the slope it makes with p.
            Arrays.sort(points, p.slopeOrder());

            //Check if any 3 (or more) adjacent points in the sorted order have equal slopes with respect to p. If so, these points, together with p, are collinear.

            assert p == points[0];
            for (int i = 1; i < points.length-1; i++) {
                if (points[i] == points[i + 1] && points[i + 1] == points[2]) {
                    lineSegmentList.add(new LineSegment(points[i], points[3]));
                }
            }
        }
    }

    public int numberOfSegments() {
        return lineSegmentList.size();
    }   // the number of line segments


    public LineSegment[] segments() {
        return lineSegmentList.toArray(new LineSegment[lineSegmentList.size()]);
    }   // the line segments
}