package chapter10.Line;

import chapter10.LineSegment.LineSegment;
import chapter10.LinearEquation2X2.LinearEquation2X2;
import chapter10.MyPoint.MyPoint;

public class Line {
    private double a;
    private double b;
    private double c;

    public final static int ON_LINE = 0;
    public final static int ABOVE_LINE = 0;
    public final static int BELOW_LINE = 0;

    public Line(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Line(MyPoint p1, MyPoint p2) {
        a = (p2.getY() - p1.getY());
        b = (p1.getX() - p2.getX());
        c = (a * p1.getX()) + (b * p1.getY());
    }

    public Line(LineSegment line) {
        this(line.getStartPoint(), line.getEndPoint());
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

    public MyPoint intersectPoint(Line line) {
        MyPoint point = null;
        if (!areParallel(line)) {
            point = new MyPoint();
            LinearEquation2X2 le = new LinearEquation2X2(a, b, c, line.a, line.b, line.c);
            point.setX(le.solveForX());
            point.setY(le.solveForY());
        }
        return point;
    }

    public int checkPointPosition(MyPoint point) {
        int position;
        double sum = a * point.getX() + b * point.getY();
        if (sum > c) {
            position = ABOVE_LINE;
        }
        else if (sum == c) {
            position = ON_LINE;
        }
        else {
            position = BELOW_LINE;
        }
        return position;
    }
}