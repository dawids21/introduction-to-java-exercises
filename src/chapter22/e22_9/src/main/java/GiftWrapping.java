import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GiftWrapping {

    private final List<? extends Point2D> points;

    public GiftWrapping(List<? extends Point2D> points) {
        this.points = points;
    }

    public List<Point2D> getSolution() {
        var convexHull = new ArrayList<Point2D>();

        var start = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            var possiblePoint = points.get(i);
            if (possiblePoint.getY() < start.getY()) {
                start = possiblePoint;
            } else if (possiblePoint.getY() == start.getY() &&
                       possiblePoint.getX() > start.getX()) {
                start = possiblePoint;
            }
        }
        convexHull.add(start);

        var current = start;

        while (true) {
            var next = current.equals(points.get(0)) ? points.get(1) : points.get(0);
            var collinearPoints = new ArrayList<Point2D>();

            for (var point : points) {

                if (point.equals(current) || point.equals(next)) {
                    continue;
                }

                Positions side = getPosition(point, current, next);

                if (side == Positions.RIGHTSIDE) {
                    next = point;
                    collinearPoints.clear();
                } else if (side == Positions.COLLINEAR) {
                    if (new Pair(current, next).compareTo(new Pair(current, point)) >=
                        0) {
                        collinearPoints.add(point);
                    } else {
                        collinearPoints.add(next);
                        next = point;
                    }
                }
            }

            if (next == start) {
                break;
            } else {
                convexHull.addAll(collinearPoints);
                convexHull.add(next);
                current = next;
            }
        }

        return convexHull;
    }

    private Positions getPosition(Point2D point, Point2D startPoint, Point2D endPoint) {
        var ax = BigDecimal.valueOf(endPoint.getX() - startPoint.getX());
        var ay = BigDecimal.valueOf(endPoint.getY() - startPoint.getY());
        var bx = BigDecimal.valueOf(point.getX() - startPoint.getX());
        var by = BigDecimal.valueOf(point.getY() - startPoint.getY());

        var crossProduct = ax.multiply(by)
                             .subtract(bx.multiply(ay));

        if (crossProduct.compareTo(BigDecimal.valueOf(0)) > 0) {
            return Positions.LEFTSIDE;
        } else if (crossProduct.compareTo(BigDecimal.valueOf(0)) == 0) {
            return Positions.COLLINEAR;
        } else {
            return Positions.RIGHTSIDE;
        }
    }

    private enum Positions {
        RIGHTSIDE, COLLINEAR, LEFTSIDE
    }
}
