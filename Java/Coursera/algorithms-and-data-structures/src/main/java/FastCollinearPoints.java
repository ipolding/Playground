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
            Point one = p;
            Double slopeOne = null;
            double lastDocumentedSlope = Double.NaN;
            for (int i = 1; i < points.length-2; i++) {
                Point two = points[i];
                Point three = points[i+1];
                Point four = points[i+2];
                slopeOne = p.slopeTo(two);
                double slopeTwo = p.slopeTo(three);
                double slopeThree = p.slopeTo(four);

                final Point[] sortedSegment = new Point[]{one, two, three, four};
                Arrays.sort(sortedSegment);

                if (slopeOne == slopeThree) {
                    if (one.slopeTo(four) != lastDocumentedSlope && one.compareTo(four) > 0) {
                        lastDocumentedSlope = one.slopeTo(four);
                        lineSegmentList.add(new LineSegment(one, four));
                    }
                }
            }
        }
    }

    //TODO prive checkForDuplicates

    public int numberOfSegments() {
        return lineSegmentList.size();
    }   // the number of line segments

    private double getSlope(Point one, Point two) {
        /*if (one.slopeTo(two) == Double.NEGATIVE_INFINITY) {
            throw new IllegalArgumentException("Found duplicate points" + one + " and " + two);
        }*/
        return one.slopeTo(two);
    }


    public LineSegment[] segments() {
        return lineSegmentList.toArray(new LineSegment[lineSegmentList.size()]);
    }   // the line segments
}