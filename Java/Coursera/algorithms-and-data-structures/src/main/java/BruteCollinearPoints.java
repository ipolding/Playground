import java.util.ArrayList;

public class BruteCollinearPoints {

/* Write a program BruteCollinearPoints.java that examines 4 points at a time and checks whether they all lie
on the same line segment, returning all such line segments.

To check whether the 4 points p, q, r, and s are collinear, check whether the three slopes
between p and q, between p and r, and between p and s are all equal.

*/

    private ArrayList<LineSegment> lineSegmentList = new ArrayList();

    public BruteCollinearPoints(Point[] points) {
        if (null == points) {throw new NullPointerException("Don't give null arguments to the constructor or include null points in an array");}

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
            for (int i = 0; i < N; i++)
                for (int j = i+1; j < N; j++)
                    for (int k = j+1; k < N; k++)
                    for (int l = k+1; l < N; l++) {
                        final Point one = a[i];
                        final Point two = a[j];
                        final Point three = a[k];
                        final Point four = a[l];

                        double oneSlopeToTwo = getSlope(one, two);
                        double twoSlopeToThree = getSlope(two, three);
                        double threeSlopeToFour = getSlope(three, four);

                        checkForDuplicates(one, two, three, four);

//                        if (oneSlopeToTwo == Double.NEGATIVE_INFINITY || twoSlopeToThree == Double.NEGATIVE_INFINITY  || threeSlopeToFour == Double.NEGATIVE_INFINITY ) {
//                            throw new IllegalArgumentException("No duplicate points allowed!");
//                        }

                        if (oneSlopeToTwo == twoSlopeToThree && twoSlopeToThree == threeSlopeToFour) {
                            lineSegmentsArrayList.add(new LineSegment(one, four));
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