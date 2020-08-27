import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GrahamAlgorithm {

    private final List<Point2D> points;

    public GrahamAlgorithm(ArrayList<Point2D> points) {
        this.points = points;
    }

    public List<Point2D> getSolution() {
        if (points.size() < 3) {
            throw new IllegalArgumentException(
                     "Set of points must contain at least 3 points");
        }

        var lowestPoint = getLowestPoint(points);
        var sortedPoints = new ArrayList<>(points);

        sortedPoints.sort(
                 Comparator.comparingDouble(p -> calculateAngle(lowestPoint, p)));
        removeTheSameAngle(sortedPoints, lowestPoint);

        var convexHull = new ArrayDeque<Point2D>();
        convexHull.push(sortedPoints.get(0));
        convexHull.push(sortedPoints.get(1));
        convexHull.push(sortedPoints.get(2));

        int i = 3;
        while (i < sortedPoints.size()) {
            var t1 = convexHull.pop();
            var t2 = convexHull.peek();
            if (isOnTheLeft(sortedPoints.get(i), t2, t1)) {
                convexHull.push(t1);
                convexHull.push(sortedPoints.get(i));
                i++;
            }
        }

        return new ArrayList<>(convexHull);
    }

    private void removeTheSameAngle(List<Point2D> points, Point2D vertex) {
        int i = 0;
        while (i < points.size() - 1) {
            if (calculateAngle(vertex, points.get(i)) ==
                calculateAngle(vertex, points.get(i + 1))) {
                if (getDistance(vertex, points.get(i)) >
                    getDistance(vertex, points.get(i + 1))) {
                    points.remove(points.get(i + 1));
                } else {
                    points.remove(points.get(i));
                }
            } else {
                i++;
            }
        }
    }

    private double getDistance(Point2D p1, Point2D p2) {
        return Math.sqrt(p1.getX() - p2.getX() * (p1.getX() - p2.getX()) +
                         (p1.getY() - p2.getY()) * (p1.getY() - p2.getY()));
    }

    private double calculateAngle(Point2D vertex, Point2D point) {
        return Math.atan2(point.getY() - vertex.getY(), point.getX() - vertex.getX());
    }

    private Point2D getLowestPoint(List<Point2D> points) {
        var lowestPoint = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            var currentPoint = points.get(i);
            if (currentPoint.getY() < lowestPoint.getY()) {
                lowestPoint = currentPoint;
            } else if (currentPoint.getY() == lowestPoint.getY() &&
                       currentPoint.getX() > lowestPoint.getX()) {
                lowestPoint = currentPoint;
            }
        }
        return lowestPoint;
    }

    private boolean isOnTheLeft(Point2D point, Point2D startPoint, Point2D endPoint) {
        var ax = BigDecimal.valueOf(endPoint.getX() - startPoint.getX());
        var ay = BigDecimal.valueOf(endPoint.getY() - startPoint.getY());
        var bx = BigDecimal.valueOf(point.getX() - startPoint.getX());
        var by = BigDecimal.valueOf(point.getY() - startPoint.getY());

        var crossProduct = ax.multiply(by)
                             .subtract(bx.multiply(ay));

        return crossProduct.compareTo(BigDecimal.valueOf(0)) > 0;
    }
}
