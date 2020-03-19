package chapter10.Line;

import chapter10.LinearEquation2X2.LinearEquation2X2;
import chapter10.Point.Point;

public class Line {
    private double a;
    private double b;
    private double c;

    public Line(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Line(Point p1, Point p2) {
        a = (p2.getY() - p1.getY());
        b = (p1.getX() - p2.getX());
        c = (a * p1.getX()) + (b * p1.getY());
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public boolean areParallel(Line line) {
        boolean parallel = false;
        LinearEquation2X2 le = new LinearEquation2X2(a, b, c, line.a, line.b, line.c);
        parallel = !le.isSolvable();
        return parallel;
    }

    public Point intersectPoint(Line line) {
        Point point = null;
        if (!areParallel(line)) {
            point = new Point();
            LinearEquation2X2 le = new LinearEquation2X2(a, b, c, line.a, line.b, line.c);
            point.setX(le.solveForX());
            point.setY(le.solveForY());
        }
        return point;
    }
}