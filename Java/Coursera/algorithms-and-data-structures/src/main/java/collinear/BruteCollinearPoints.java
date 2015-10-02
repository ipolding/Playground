package collinear;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {

/* Write a program collinear.BruteCollinearPoints.java that examines 4 points at a time and checks whether they all lie
on the same line segment, returning all such line segments.

To check whether the 4 points p, q, r, and s are collinear, check whether the three slopes
between p and q, between p and r, and between p and s are all equal.

*/

    private ArrayList<LineSegment> lineSegmentList = new ArrayList();

    public BruteCollinearPoints(Point[] points) {
        if (null == points) {
            throw new NullPointerException("Don't give null arguments to the constructor or include null points in an array");
        }


        lineSegmentList = get4Tuples(points);

        /*TODO Corner cases.
        Throw a java.lang.NullPointerException either the argument to the constructor
        is null or if any point in the array is null.

        Throw a java.lang.IllegalArgumentException if the argument to the constructor contains a repeated point.
         */
    }

    public LineSegment[] segments() {
        return lineSegmentList.toArray(new LineSegment[lineSegmentList.size()]);
    }

    private ArrayList<LineSegment> get4Tuples(Point[] a) {
        ArrayList<LineSegment> lineSegmentsArrayList = new ArrayList();
        int N = a.length;
        Point successfulFour = null;
        for (int _first = 0; _first < N - 3; _first++) {

            for (int _second = _first + 1; _second < N; _second++) {
                for (int _third = _second + 1; _third < N; _third++) {
                    for (int _fourth = _third + 1; _fourth < N; _fourth++) {
                        Point one = a[_first]; //on first iteration, this is 0
                        Point two = a[_second];
                        Point three = a[_third];
                        Point four = a[_fourth]; //on first iteration, this is N-1

                        final Point[] sortedPoints = new Point[]{one, two, three, four};
                        Arrays.sort(sortedPoints);

                        one = sortedPoints[0];
                        two = sortedPoints[1];
                        three = sortedPoints[2];
                        four = sortedPoints[3];

                        double oneSlopeToTwo = getSlope(one, two);
                        double twoSlopeToThree = getSlope(two, three);
                        double threeSlopeToFour = getSlope(three, four);

                        checkForDuplicates(one, two, three, four);

//                            if (oneSlopeToTwo == Double.NEGATIVE_INFINITY || twoSlopeToThree == Double.NEGATIVE_INFINITY  || threeSlopeToFour == Double.NEGATIVE_INFINITY ) {
//                                throw new IllegalArgumentException("No duplicate points allowed!");
//                            }

                        //One approach is to form a line segment only if the 4 points are in ascending order
                        if (oneSlopeToTwo == twoSlopeToThree && twoSlopeToThree == threeSlopeToFour) {

                            if (null == successfulFour || getSlope(three, four) != getSlope(three, successfulFour)) {

//                                System.out.printf("%s = %s\n", "one", one);
//                                System.out.printf("%s = %s\n", "two", two);
//                                System.out.printf("%s = %s\n", "three", three);
//                                System.out.printf("%s = %s\n", "four", four);
//                                System.out.printf("%s = %s\n", "successfulFour", successfulFour);
                                successfulFour = four;

                                lineSegmentsArrayList.add(new LineSegment(one, four));

                            }

                           /*
                           * The problem is that, given for example the `collinear.LineSegment` (0|0) -> (1|1) -> (2|2) -> (3|3) -> (4|4), while the first pass-through yields the proper `collinear.LineSegment` (0|0) -> (4|4), the second one also returns another shorter segment (1|1) -> (4|4) (or depending on your implementation possibly even a completely incorrect one like (2|2) -> (4|4)).

                            Here are a few hints that will hopefully guide you towards the solution without giving too much away ;)
                            Feel free to ask any further questions about them.

                            What is the actual order of the `collinear.Point`s when you find the shorter segments?
                            Particularly, what happened to point (0|0) (from the example)?
                            Based on this information, can you determine whether you are currently dealing with a smaller sub-segment?
                            Is there a way to control the order of the points with equal slopes?
                            Which algorithm does Java's `Arrays.sort()` use for sorting `collinear.Point`s? What are the key properties of this algorithm?

Good luck!
                           *
                           *
                           *
                           * */

                        }
                    }
                }
            }
        }

        return lineSegmentsArrayList;
    }

    private void checkForDuplicates(Point one, Point two, Point three, Point four) {
        getSlope(one, three);
        getSlope(one, four);
        getSlope(two, four);
    }

    private double getSlope(Point one, Point two) {
        if (one.slopeTo(two) == Double.NEGATIVE_INFINITY) {
            throw new IllegalArgumentException("Found duplicate points" + one + " and " + two);
        }
        return one.slopeTo(two);
    }
}