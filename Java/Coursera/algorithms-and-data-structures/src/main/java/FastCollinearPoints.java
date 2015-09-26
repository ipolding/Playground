import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class FastCollinearPoints {

    private ArrayList<LineSegment> lineSegmentList = new ArrayList();

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {

        Arrays.sort(points);

        //Think of p as the origin.
        int pointTwoIndex = 1;
        double mostRecentSlope = Double.NaN;
        for (Point p : points) {

            Arrays.sort(points, p.slopeOrder());
            Point one = points[0];
            int maxSegmentLength = 2;


            int nextIndexToCompare = 2;

            Point segmentEndpoint = points[nextIndexToCompare];

            for (int i = 1 ; i < points.length; i++) {
                Point two = points[i];
                checkForDuplicates(one, two);
                if (getSlope(one, two) == mostRecentSlope) {
                    break;
                }


            Stack<Point> segmentStack = new Stack<Point>();
                double segmentSlope = getSlope(one, two);

                segmentStack.add(one);
                segmentStack.add(two);

            while (getSlope(one, segmentEndpoint) == segmentSlope && nextIndexToCompare < points.length) {

                segmentStack.add(segmentEndpoint);

                if (++nextIndexToCompare < points.length) {
                    segmentEndpoint = points[nextIndexToCompare];
                }
                maxSegmentLength++;
            }
            if (segmentStack.size() > 3) {


                Object[] segment = segmentStack.toArray();
                Point first = (Point) segment[segment.length-1];
                Arrays.sort(segment);
                Point start = (Point) segment[0];
                Point finish = (Point) segment[segment.length - 1];

                if (first != finish) { //check for reverse segments
                    lineSegmentList.add(new LineSegment(start, finish));
                    mostRecentSlope = getSlope(start, finish);
                }

            }
            }
        }
    }

    private void checkForDuplicates(Point one, Point two) {
        if (one.slopeTo(two) == Double.NEGATIVE_INFINITY) {
            throw new IllegalArgumentException("Found duplicate points" + one + " and " + two);
        }
    }

    private void versionOne(Point[] points, Point p) {
        int consecutivePoints = 0;
        //For each other point q, determine the slope it makes with p.
        Arrays.sort(points, p.slopeOrder());

        //Check if any 3 (or more) adjacent points in the sorted order have equal slopes with respect to p. If so, these points, together with p, are collinear.
        assert p == points[0];
        Point one = p;
        Double slopeOne = null;
        double lastDocumentedSlope = Double.NaN;
        for (int i = 1; i < points.length - 2; i++) {
            Point two = points[i];
            Point three = points[i + 1];
            Point four = points[i + 2];
            slopeOne = p.slopeTo(two);
            double slopeTwo = p.slopeTo(three);
            double slopeThree = p.slopeTo(four);

            final Point[] sortedSegment = new Point[]{one, two, three, four};
            Arrays.sort(sortedSegment);

            double oneSlopeToTwo = getSlope(one, two);
            double twoSlopeToThree = getSlope(two, three);
            double threeSlopeToFour = getSlope(three, four);

            if (oneSlopeToTwo == twoSlopeToThree && twoSlopeToThree == threeSlopeToFour) {
//                if (slopeOne == slopeTwo && slopeTwo == slopeThree) { /* Creates short points*/
                if (one.slopeTo(four) != lastDocumentedSlope && one.compareTo(four) > 0) {
                    lastDocumentedSlope = one.slopeTo(four);
                    lineSegmentList.add(new LineSegment(one, four));
                }
            }
        }
    }

    public int numberOfSegments() {
        return lineSegmentList.size();
    }   // the number of line segments

    private double getSlope(Point one, Point two) {

        return one.slopeTo(two);
    }


    public LineSegment[] segments() {
        return lineSegmentList.toArray(new LineSegment[lineSegmentList.size()]);
    }   // the line segments


}