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

        if (points.size() == 3) {
            Pair[] pairs = {new Pair(points.get(0), points.get(1)),
                            new Pair(points.get(1), points.get(2)),
                            new Pair(points.get(2), points.get(0))};
            return Collections.min(Arrays.asList(pairs));
        } else if (points.size() == 2) {
            return new Pair(points.get(0), points.get(1));
        }

        var orderedByY = new ArrayList<Point2D>(points);
        orderedByY.sort((p1, p2) -> {
            int compare;
            if (p1.getY() != p2.getY()) {
                compare = p1.getY() > p2.getY() ? 1 : -1;
            } else {
                if (p1.getX() == p2.getX()) {
                    compare = 0;
                } else {
                    compare = p1.getX() > p2.getX() ? 1 : -1;
                }
            }
            return compare;
        });

        return null;
    }
}
