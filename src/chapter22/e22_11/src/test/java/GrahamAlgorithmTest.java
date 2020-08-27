import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GrahamAlgorithmTest {

    @Test
    void return_convex_hull_from_all_points() {
        var points = new ArrayList<Point2D>();
        points.add(new Point2D(1, 1));
        points.add(new Point2D(4, 2));
        points.add(new Point2D(6, 6));
        points.add(new Point2D(7, 6));
        points.add(new Point2D(4, 4));
        points.add(new Point2D(4, 6.5));
        points.add(new Point2D(3, 4));
        points.add(new Point2D(1, 7));

        var grahamAlgorithm = new GrahamAlgorithm(points);
        var convexHull = grahamAlgorithm.getSolution();

        List<Point2D> expected = new ArrayList<>();
        expected.add(new Point2D(1, 1));
        expected.add(new Point2D(4, 2));
        expected.add(new Point2D(7, 6));
        expected.add(new Point2D(4, 6.5));
        expected.add(new Point2D(1, 7));

        assertEquals(expected, convexHull);
    }
}