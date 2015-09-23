import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {

/* Write a program BruteCollinearPoints.java that examines 4 points at a time and checks whether they all lie
on the same line segment, returning all such line segments.

To check whether the 4 points p, q, r, and s are collinear, check whether the three slopes
between p and q, between p and r, and between p and s are all equal.

*/

    private ArrayList<LineSegment> lineSegmentList = new ArrayList();

    public BruteCollinearPoints(Point[] points) {
        if (null == points) {throw new NullPointerException("Don't give null arguments to the constructor or include null points in an array");}


        Arrays.sort(points);

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
            for (int i = 0; i < N-3; i++)
                for (int j = N-1; j > 0; j--)
                    /*for (int k = N-2; k > 1; k--)
                    for (int l = N-3; l > 2; l--)*/ {
                        final Point one = a[i];
                        final Point two = a[j];
                      //  final Point three = a[k];
                       // final Point four = a[l];

                        System.out.println("point one = " + one);
                        System.out.println("point two = " + two);
                      //  System.out.println("point three = " + three);
                      //  System.out.println("point four = " + four);

                        double oneSlopeToTwo = getSlope(one, two);
                       // double twoSlopeToThree = getSlope(two, three);
                       // double threeSlopeToFour = getSlope(three, four);

                       // checkForDuplicates(one, two, three, four);

//                        if (oneSlopeToTwo == Double.NEGATIVE_INFINITY || twoSlopeToThree == Double.NEGATIVE_INFINITY  || threeSlopeToFour == Double.NEGATIVE_INFINITY ) {
//                            throw new IllegalArgumentException("No duplicate points allowed!");
//                        }

                    System.out.println(new LineSegment(one, two));




//                    if (oneSlopeToTwo == twoSlopeToThree && twoSlopeToThree == threeSlopeToFour) {
//                           /* *
//                            The problem is that, given for example the `LineSegment`
//                                    (0|0) -> (1|1) -> (2|2) -> (3|3) -> (4|4)
//                            , while the first pass-through yields the proper `LineSegment` (0|0) -> (4|4),
//                            the second one also returns another shorter segment (1|1) -> (4|4) (or depending on your implementation possibly even a completely incorrect one like (2|2) -> (4|4)).
//
//                            Here are a few hints that will hopefully guide you towards the solution without giving too much away ;)
//                            Feel free to ask any further questions about them.
//
//                            What is the actual order of the `Point`s when you find the shorter segments?
//                            Particularly, what happened to point (0|0) (from the example)?
//
//                            Based on this information, can you determine whether you are currently dealing with a smaller sub-segment?
//                            Is there a way to control the order of the points with equal slopes?
//                            Which algorithm does Java's `Arrays.sort()` use for sorting `Point`s? What are the key properties of this algorithm?
//
//                            Good luck!
//                           * */
//
//                            System.out.println(new LineSegment(one, four));
//                        }
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