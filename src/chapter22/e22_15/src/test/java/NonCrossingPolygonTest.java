import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class NonCrossingPolygonTest {

    @Test
    @DisplayName("Return ordered list of points that forms non-cross polygon")
    void return_ordered_list_of_points_that_forms_non_cross_polygon() {
        var points = new ArrayList<Point2D>();
        points.add(new Point2D(1, 1));
        points.add(new Point2D(1, 4));
        points.add(new Point2D(2, 2));
        points.add(new Point2D(2, 6));
        points.add(new Point2D(5, 1));
        points.add(new Point2D(5, 4));

        var nonCrossingPolygon = new NonCrossingPolygon(points);

        var expected = new ArrayList<Point2D>();
        expected.add(new Point2D(5, 1));
        expected.add(new Point2D(5, 4));
        expected.add(new Point2D(2, 6));
        expected.add(new Point2D(1, 4));
        expected.add(new Point2D(2, 2));
        expected.add(new Point2D(1, 1));

        Assertions.assertEquals(expected, nonCrossingPolygon.solve());
    }
}