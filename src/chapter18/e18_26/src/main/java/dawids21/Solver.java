package dawids21;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solver {
    public static LinkedList<Directions> findPath(Maze mazeLayout) {
        var path = new LinkedList<Directions>();
        return path;
    }

    private static ArrayList<Directions> checkNeighbours(Point point, Maze mazeLayout) {
        var possibleMoves = new ArrayList<Directions>();
        for (Directions direction : Directions.values()) {
            Point currentNeighbour = null;
            switch (direction) {
                case UP:
                    currentNeighbour = new Point(point.getX(), point.getY() - 1);
                    break;
                case DOWN:
                    currentNeighbour = new Point(point.getX(), point.getY() + 1);
                    break;
                case RIGHT:
                    currentNeighbour = new Point(point.getX() + 1, point.getY());
                    break;
                case LEFT:
                    currentNeighbour = new Point(point.getX() - 1, point.getY());
                    break;
            }
            if (mazeLayout.isPointInsideMaze(point) && mazeLayout.isCellFree(currentNeighbour) && checkAllFourSquares(
                    point,
                    mazeLayout)) {
                possibleMoves.add(direction);
            }
        }
        return possibleMoves;
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
        if (!mazeLayout.isPointInsideMaze(point0) || !mazeLayout.isPointInsideMaze(point1) || !mazeLayout.isPointInsideMaze(
                point2)) {
            return false;
        } else if (mazeLayout.isCellCrossed(point0) || mazeLayout.isCellCrossed(point1) || mazeLayout.isCellCrossed(
                point2)) {
            return true;
        } else {
            return mazeLayout.isCellFree(point0) || mazeLayout.isCellFree(point1) || mazeLayout.isCellFree(point2);
        }
    }
}
