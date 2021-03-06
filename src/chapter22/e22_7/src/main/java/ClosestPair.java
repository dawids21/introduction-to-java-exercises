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

        // Base cases
        if (points.size() == 3) {
            Pair[] pairs = {new Pair(points.get(0), points.get(1)),
                            new Pair(points.get(1), points.get(2)),
                            new Pair(points.get(2), points.get(0))};
            return Collections.min(Arrays.asList(pairs));
        } else if (points.size() == 2) {
            return new Pair(points.get(0), points.get(1));
        }

        // Sort points according to their Y coordinates
        var orderedByY = new ArrayList<>(points);
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

        // Divide points between two sides
        var leftSide = new ArrayList<Point2D>();
        var rightSide = new ArrayList<Point2D>();
        for (int i = 0; i < points.size(); i++) {
            if (i < (points.size() + 1) / 2) {
                leftSide.add(points.get(i));
            } else {
                rightSide.add(points.get(i));
            }
        }

        // Recursively calculate the closest pairs of point in each side
        var closestPairInLeft = recursivelyFindDistance(leftSide);
        var closestPairInRight = recursivelyFindDistance(rightSide);

        // Take last point in left side as a midpoint
        var midPoint = leftSide.get(leftSide.size() - 1);

        // Get closer of the two pairs in both sides
        var minPair = closestPairInLeft.compareTo(closestPairInRight) <= 0 ?
                 closestPairInLeft : closestPairInRight;
        var minDistance = minPair.getDistance();

        // Get points that may be closer than minPair
        var stripL = new ArrayList<Point2D>();
        var stripR = new ArrayList<Point2D>();
        for (var point : orderedByY) {
            if (leftSide.contains(point) &&
                point.getX() > midPoint.getX() - minDistance) {
                stripL.add(point);
            } else if (rightSide.contains(point) &&
                       point.getX() <= midPoint.getX() + minDistance) {
                stripR.add(point);
            }
        }

        // Check possible points
        for (var point : stripL) {
            int i = 0;
            while (i < stripR.size() && stripR.get(i)
                                              .getY() < point.getY() - minDistance) {
                i++;
            }
            while (i < stripR.size() && stripR.get(i)
                                              .getY() <= point.getY() + minDistance) {
                var pairBetweenSides = new Pair(point, stripR.get(i));
                minPair = minPair.compareTo(pairBetweenSides) <= 0 ? minPair :
                         pairBetweenSides;
                i++;
            }
        }

        return minPair;
    }
}
