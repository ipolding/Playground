package collinear;

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


            Stack<Point> pointStack = new Stack<Point>();
                double segmentSlope = getSlope(one, two);

                pointStack.add(one);
                pointStack.add(two);

            while (getSlope(one, segmentEndpoint) == segmentSlope && nextIndexToCompare < points.length) {

                pointStack.add(segmentEndpoint);

                if (++nextIndexToCompare < points.length) {
                    segmentEndpoint = points[nextIndexToCompare];
                }
                maxSegmentLength++;
            }
            if (pointStack.size() > 3) {


                Object[] segment = pointStack.toArray();
                Point first = (Point) segment[segment.length-1];
//                System.out.println(Arrays.asList(segment));
                Arrays.sort(segment);
                Point start = (Point) segment[0];
                Point finish = (Point) segment[segment.length - 1];
                
                //

//                 if (first != finish) { //check for reverse segments
                    lineSegmentList.add(new LineSegment(start, finish));
                    mostRecentSlope = getSlope(start, finish);
//                }

            }
            }
        }
    }

    private void checkForDuplicates(Point one, Point two) {
        if (one.slopeTo(two) == Double.NEGATIVE_INFINITY) {
            throw new IllegalArgumentException("Found duplicate points" + one + " and " + two);
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