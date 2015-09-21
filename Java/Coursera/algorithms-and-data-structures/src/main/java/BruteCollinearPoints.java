public class BruteCollinearPoints {

/* Write a program BruteCollinearPoints.java that examines 4 points at a time and checks whether they all lie
on the same line segment, returning all such line segments.

To check whether the 4 points p, q, r, and s are collinear, check whether the three slopes
between p and q, between p and r, and between p and s are all equal.

*/

    public BruteCollinearPoints(Point[] points) {
        if (null == points) {throw new NullPointerException("Don't give null arguments to the constructor or include null points in an array");}

        /*TODO Corner cases.
        Throw a java.lang.NullPointerException either the argument to the constructor
        is null or if any point in the array is null.

        Throw a java.lang.IllegalArgumentException if the argument to the constructor contains a repeated point.
         */
    }

    public LineSegment[] segments() {
        return null;
    }
}