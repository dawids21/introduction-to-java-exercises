import java.util.ArrayList;
import java.util.List;

public class NonCrossingPolygon {

    private final List<Point2D> points;

    public NonCrossingPolygon(List<Point2D> points) {
        this.points = points;
    }

    public List<Point2D> solve() {
        var lowestPoint = getLowestPoint(points);
        var sortedPoints = new ArrayList<>(points);
        sortedPoints.sort((p1, p2) -> {
            var angle1 = calculateAngle(lowestPoint, p1);
            var angle2 = calculateAngle(lowestPoint, p2);
            if (angle1 > angle2) {
                return 1;
            } else if (angle1 == angle2) {
                if (getDistance(lowestPoint, p1) < getDistance(lowestPoint, p2)) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        });

        return sortedPoints;
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

    private double calculateAngle(Point2D vertex, Point2D point) {
        return Math.atan2(point.getY() - vertex.getY(), point.getX() - vertex.getX());
    }

    private double getDistance(Point2D p1, Point2D p2) {
        return Math.sqrt(p1.getX() - p2.getX() * (p1.getX() - p2.getX()) +
                         (p1.getY() - p2.getY()) * (p1.getY() - p2.getY()));
    }
}
