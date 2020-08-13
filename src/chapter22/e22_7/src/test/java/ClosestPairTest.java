import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClosestPairTest {

    @Test
    void return_pair_of_points_that_are_closest_to_each_other() {
        var points = new HashSet<Point2D>();
        points.add(new Point2D(0, 9));
        points.add(new Point2D(5, 8));
        points.add(new Point2D(2, 7));
        points.add(new Point2D(7, 6));
        points.add(new Point2D(4, 5));
        points.add(new Point2D(1, 4));
        points.add(new Point2D(3, 4));
        points.add(new Point2D(2, 2));
        points.add(new Point2D(6, 2));
        points.add(new Point2D(4, 0));

        Pair closestPair = ClosestPair.find(points);
        Pair expectedPair = new Pair(new Point2D(3, 4), new Point2D(4, 5));

        assertEquals(expectedPair, closestPair);
    }
}