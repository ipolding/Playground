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
        Point two = null;
        for (Point p : points) {

            if (pointTwoIndex + 1 < points.length) {
                two = points[pointTwoIndex]; //use then increment
                pointTwoIndex ++;
            }

            //PRINT System.out.printf("p is %s\n", p);
            int maxSegmentLength = 2;

            //PRINT System.out.printf("before sorting points[0] is %s\n", points[0]);


            Arrays.sort(points, p.slopeOrder());


            //PRINT System.out.printf("Aftersorting points[0] is %s\n", points[0]);
            Point one = points[0];




            int nextIndexToCompare = 2;
            //PRINT System.out.printf("To calculate the segment slope, we are comparing slope of %s to %s\n", one, two);
            double segmentSlope = getSlope(one,two);
            //PRINT System.out.printf("segmentSlope = %s\n", segmentSlope);
            Point segmentEndpoint = points[nextIndexToCompare];

            //PRINT System.out.printf("Before entering the while loop, we are comparing slope of %s to %s\n", one, segmentEndpoint);
            //PRINT System.out.printf("getSlope(one, segmentEndpoint) = %s\n", getSlope(one, segmentEndpoint));
            //PRINT System.out.printf("segmentSlope = %s and getSlope = %s so getSlope==segmentSlope = %s\n", segmentSlope, getSlope(one, segmentEndpoint), getSlope(one, segmentEndpoint) == segmentSlope);
            Stack<Point> segmentStack = new Stack<Point>();
            segmentStack.add(one);
            while(getSlope(one, segmentEndpoint) == segmentSlope && nextIndexToCompare < points.length) {
                //PRINT System.out.printf("getSlope(one, segmentEndpoint) == segmentSlope so we're now ");

                segmentStack.add(segmentEndpoint);

                if (++nextIndexToCompare < points.length) {

                    segmentEndpoint = points[nextIndexToCompare];
                    System.out.println("segmentEndPoint switched to " + segmentEndpoint);
                }
                System.out.printf("incrementing segmentLength from %d", maxSegmentLength);
                maxSegmentLength++;
                System.out.printf(" to %d\n", maxSegmentLength);
                //PRINT System.out.printf("To continue the while loop, we are comparing slope of %s to %s\n", one, segmentEndpoint);
            }
            //PRINT System.out.println("We have exited the while loop");
            if (maxSegmentLength >3) {

                System.out.println(segmentStack);
                Object[] segment = segmentStack.toArray();
                Arrays.sort(segment);
                lineSegmentList.add(new LineSegment((Point) segment[0], (Point) segment[segment.length-1]));

            } else {
                //PRINT System.out.printf("Not building a segment because the length is only %s\n", maxSegmentLength);
            }
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
        for (int i = 1; i < points.length-2; i++) {
            Point two = points[i];
            Point three = points[i+1];
            Point four = points[i+2];
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