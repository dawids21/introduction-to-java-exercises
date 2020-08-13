import java.util.*;

public class ClosestPair {

    public static Pair find(Collection<? extends Point2D> points) {

        var orderedPoints = new ArrayList<Point2D>(points);
        orderedPoints.sort((p1, p2) -> {
            int compare;
            if (p1.getX() != p2.getX()) {
                compare = p1.getX() > p2.getX() ? 1 : -1;
            } else {
                if (p1.getY() == p2.getY()) {
                    compare = 0;
                } else {
                    compare = p1.getY() > p2.getY() ? 1 : -1;
                }
            }
            return compare;
        });

        return recursivelyFindDistance(orderedPoints);
    }

    private static Pair recursivelyFindDistance(List<Point2D> points) {
        return null;
    }
}
