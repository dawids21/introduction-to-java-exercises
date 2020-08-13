import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PairTest {

    static class GetDistance {

        @Test
        void return_distance_2_when_points_1_4_and_3_4() {
            var pair = new Pair(new Point2D(1, 4), new Point2D(3, 4));
            assertEquals(2, pair.getDistance());
        }

        @Test
        void return_distance_5_when_points_1_4_and_4_0() {
            var pair = new Pair(new Point2D(1, 4), new Point2D(4, 0));
            assertEquals(5, pair.getDistance());
        }
    }
}