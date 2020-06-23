package dawids21;

import java.util.LinkedList;

public class Solver {
    public static LinkedList<Directions> findPath(Maze mazeLayout) {
        if (mazeLayout == null) {
            throw new NullPointerException();
        }
        var path = new LinkedList<Directions>();
        var head = new Point(Maze.ENTRY.getX(), Maze.ENTRY.getY());
        searchForPath(head, path, mazeLayout);
        return path;
    }

    private static boolean searchForPath(Point head, LinkedList<Directions> path, Maze mazeLayout) {
        mazeLayout.setCellOccupied(head);
        if (head.equals(Maze.EXIT)) {
            return true;
        }
        for (Directions direction : Directions.values()) {
            Point nextMove = null;
            switch (direction) {
                case UP:
                    nextMove = new Point(head.getX(), head.getY() - 1);
                    break;
                case DOWN:
                    nextMove = new Point(head.getX(), head.getY() + 1);
                    break;
                case RIGHT:
                    nextMove = new Point(head.getX() + 1, head.getY());
                    break;
                case LEFT:
                    nextMove = new Point(head.getX() - 1, head.getY());
                    break;
            }
            if (mazeLayout.isPointInsideMaze(nextMove) && mazeLayout.isCellFree(nextMove) && checkAllFourSquares(
                    nextMove,
                    mazeLayout) && searchForPath(
                    nextMove,
                    path,
                    mazeLayout)) {
                path.addFirst(direction);
                return true;
            }
        }
        mazeLayout.setCellFree(head);
        return false;
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
            return true;
        } else if (mazeLayout.isCellCrossed(point0) || mazeLayout.isCellCrossed(point1) || mazeLayout.isCellCrossed(
                point2)) {
            return true;
        } else {
            return mazeLayout.isCellFree(point0) || mazeLayout.isCellFree(point1) || mazeLayout.isCellFree(point2);
        }
    }
}
