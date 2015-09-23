import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(JUnit4.class)
public class PointTest {

    @Test
    public void testCompareTo_should_compare_points_by_y_coordinates() throws Exception {

        Point a = new Point(2, 1);
        Point b = new Point(1, 3);
        Point c = new Point(3, 3);
        Point d = new Point(3, 2);
        Point e = new Point(4, 2);

        assertEquals(-1, a.compareTo(b));
        assertEquals(1, b.compareTo(a));
        assertEquals(0, a.compareTo(a));
        assertEquals(-1, b.compareTo(c));
        assertEquals(-1, d.compareTo(e));
        assertEquals(+1, e.compareTo(d));
        assertEquals(0, d.compareTo(d));
        assertEquals(0, c.compareTo(c));
        assertEquals(0, b.compareTo(b));
    }

    @Test
    public void testCompareTo_should_break_ties_by_x_coordinates() throws Exception {
        Point d = new Point(3, 2);
        Point e = new Point(4, 2);
        assertEquals(-1, d.compareTo(e));
        assertEquals(+1, e.compareTo(d));
    }

    @Test
    public void testSlopeTo_should_return_the_slope_between_the_invoking_point_x0_y0__and_the_argument_point__x1_y1() throws Exception {

        Point slope1_a = new Point(0, 0);
        Point slope1_b = new Point(1, 1);
        Point slope1_c = new Point(5, 5);

        assertEquals(1, slope1_a.slopeTo(slope1_b), 0);
        assertEquals(1, slope1_b.slopeTo(slope1_c), 0);
        assertEquals(1, slope1_a.slopeTo(slope1_c), 0);
        assertEquals(1, slope1_a.slopeTo(slope1_c), 0);

        assertEquals(-1, slope1_c.slopeTo(slope1_b), 0);
        assertEquals(-1, slope1_b.slopeTo(slope1_a), 0);
        assertEquals(-1, slope1_c.slopeTo(slope1_a), 0);
    }

    @Test
    public void test_slopeTo_should_Treat_the_slope_of_a_horizontal_line_segment_as_positive_zero() {
        Point horizontal_a = new Point(1, 1);
        Point horizontal_b = new Point(9, 1);

        assertEquals(0.0, horizontal_a.slopeTo(horizontal_b), 0);
        System.out.println(horizontal_a.slopeTo(horizontal_b));
        assertEquals(0.0, horizontal_b.slopeTo(horizontal_a), 0);
    }

    @Test
    public void test_slopeTo_should_Treat_the_slope_of_a_vertical_line_segment_as_positive_infinity() {
        Point vertical_a = new Point(1, 1);
        Point vertical_b = new Point(1, 10);

        assertEquals(Double.POSITIVE_INFINITY, vertical_a.slopeTo(vertical_b), 0);

    }

    @Test
    public void test_slopeTo_should_treat_the_slope_of_a_degenerate_line_segment_between_a_point_and_itself_as_negative_infinity() {
        Point degenerate_a = new Point(2, 2);
        Point degenerate_b = new Point(2, 2);

        assertEquals(Double.NEGATIVE_INFINITY, degenerate_a.slopeTo(degenerate_b), 0);
        assertEquals(Double.NEGATIVE_INFINITY, degenerate_a.slopeTo(degenerate_a), 0);
    }

    @Test
    public void testSlopeOrder_should_return_a_comparator_that_compares_its_two_argument_points_by_the_slopes_they_make_with_the_invoking_point_x0_y0() throws Exception {
        Point testObj = new Point(2, 2);

        assertTrue(testObj.slopeOrder() instanceof Comparator);
    }

    @Test
    public void testSlopeOrder_returns_a_comparator_that_compares_its_two_argument_points_by_the_slopes_they_make_with_the_invoking_point_x0_y0() throws Exception {
        Point pointA = new Point(1, 1);
        Point pointB = new Point(2, 3);
        Point pointC = new Point(3, 2);

        assertEquals(-1, pointA.slopeOrder().compare(pointC, pointB));
        assertEquals(+1, pointA.slopeOrder().compare(pointB, pointC));
    }

    @Test
    public void testSlopeOrder_should_Treat_horizontal_line_segments_as_in_the_slopeTo_method() {
    }

    @Test
    public void testSlopeOrder_should_Treat_vertical_line_segments_as_in_the_slopeTo_method() {

    }

    @Test
    public void testSlopeOrder_should_Treat_degenerate_line_segments_as_in_the_slopeTo_method() {

    }

    @Test
    public void testSlopeOrder() throws Exception {

    }

}