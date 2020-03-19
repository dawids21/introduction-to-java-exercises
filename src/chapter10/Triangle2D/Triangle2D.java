package chapter10.Triangle2D;

import chapter10.MyPoint.MyPoint;

public class Triangle2D {
    private MyPoint p1;
    private MyPoint p2;
    private MyPoint p3;

    public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Triangle2D() {
        this(new MyPoint(0, 0), new MyPoint(1, 1), new MyPoint(2, 5));
    }

    public double getArea() {
        double area = 0;
        double side1 = p1.getDistance(p2);
        double side2 = p1.getDistance(p3);
        double side3 = p2.getDistance(p3);
        double s = (side1 + side2 + side3) / 2.0;
        area = Math.sqrt(s * (s-side1) * (s - side2) * (s - side3));
        return area;
    }
    
}