package chapter10.Triangle2D;

import chapter10.MyPoint.MyPoint;

public class TestTriangle2D {
    public static void main(String[] args) {
        Triangle2D triangle = new Triangle2D(new MyPoint(0, 0), new MyPoint(0, 3), new MyPoint(4, 0));
        System.out.println("Area: " + triangle.getArea());
    }    
}