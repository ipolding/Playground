package collinear;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BruteCollinearPointsTest {

    final boolean exceptionNotThrown = false;

    @Test
    public void test_throwsNullPointerExceptionWhenArgumentToConstructorIsNull() throws Exception {

        try {
            new BruteCollinearPoints(null);
            Assert.assertTrue(exceptionNotThrown);
        } catch (NullPointerException npe) {
            Assert.assertEquals("Don't give null arguments to the constructor", npe.getMessage());
        }

    }

    @Test
    public void test_throwsNullPointerExceptionWhenAnyPointInArrayIsNull() throws Exception {

        try {
            Point[] nullPointsArray = new Point[] {new Point(1,0), new Point(9,4), null, new Point(3,1)};
            new BruteCollinearPoints(nullPointsArray);
            Assert.assertTrue(exceptionNotThrown);
        } catch (NullPointerException npe) {
            Assert.assertEquals("Don't include null points in an array", npe.getMessage());
        }

    }

    @Test
    public void test_throwsIllegalArgumentExceptionWhenAnyPointInArrayIsRepeated() throws Exception {

        try {

            Assert.assertTrue(exceptionNotThrown);
        } catch (IllegalArgumentException iae) {
            Assert.assertEquals("Do not repeat Points in the given array!", iae.getMessage());
        }

    }

    @Test
    public void test_finds_all_line_segments_containing_4_points() {

    }

    @Test
    public void test_returns_theNumberOfSegments() {

        Point[] pointsArray = new Point[] {};
        BruteCollinearPoints testObj = new BruteCollinearPoints(pointsArray);


    }        // the number of line segments


    @Test
    public void test_returns_array_of_line_segments() {
        Point[] pointsArray = new Point[] {};
        BruteCollinearPoints testObj = new BruteCollinearPoints(pointsArray);

        LineSegment[] lineSegments = testObj.segments();
        Assert.assertNotNull(lineSegments);
    }



}