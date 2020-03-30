package chapter11.Triangle;

import chapter11.SimpleGeometricObject.SimpleGeometricObject;
import chapter12.IllegalTriangleException.IllegalTriangleException;

public class Triangle extends SimpleGeometricObject {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    Triangle() {

    }

    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
        if (side1 >= side2 + side3 || side1 >= side2 + side3 || side1 >= side2 + side3) {
            throw new IllegalTriangleException();
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public double getArea() {
        double area = 0;
        double s = (side1 + side2 + side3) / 2.0;
        area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        return area;
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }
}