package dawids21;

import java.util.LinkedList;

public class Solver {
    public static LinkedList<Directions> findPath(Maze mazeLayout) {
        var path = new LinkedList<Directions>();
        return path;
    }

    private static boolean checkAllFourSquares(Point point, Maze mazeLayout) {
        Point[] points = new Point[8];
        points[0] = new Point(point.getX() - 1, point.getY() - 1);
        points[1] = new Point(point.getX(), point.getY() - 1);
        points[2] = new Point(point.getX() + 1, point.getY() - 1);
        points[3] = new Point(point.getX() - 1, point.getY());
        points[4] = new Point(point.getX() + 1, point.getY());
        points[5] = new Point(point.getX() - 1, point.getY() + 1);
        points[6] = new Point(point.getX(), point.getY() + 1);
        points[7] = new Point(point.getX() + 1, point.getY() + 1);
        return checkFourSquare(points[0], points[1], points[3], mazeLayout) &&
                checkFourSquare(points[1], points[2], points[4], mazeLayout) &&
                checkFourSquare(points[3], points[5], points[6], mazeLayout) &&
                checkFourSquare(points[4], points[6], points[7], mazeLayout);
    }

    private static boolean checkFourSquare(Point point0, Point point1, Point point2, Maze mazeLayout) {
        if (mazeLayout.isCellCrossed(point0) || mazeLayout.isCellCrossed(point1) || mazeLayout.isCellCrossed(point2)) {
            return true;
        }
        return mazeLayout.isCellFree(point0) || mazeLayout.isCellFree(point1) || mazeLayout.isCellFree(point2);
    }
}
