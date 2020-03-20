package chapter10.Line;

import chapter10.MyPoint.MyPoint;

/**
 * TestLine
 */
public class TestLine {
    public static void main(String[] args) {
        Line line1 = new Line(4, 6, 2);
        System.out.println("A = " + line1.getA());
        System.out.println("B = " + line1.getB());
        System.out.println("C = " + line1.getC());
        Line line2 = new Line(2, 3, 2);
        if (line1.areParallel(line2)) {
            System.out.println("Lines are parallel");
        }
        else {
            System.out.println("Lines are not parallel");
        }
        
        MyPoint intersectPoint = line1.intersectPoint(line2);

        if (intersectPoint != null) {
            System.out.println( "Intersect point: ("
                                + intersectPoint.getX() + ", "
                                + intersectPoint.getY() +")");
        }
        else {
            System.out.println("Lines are parallel");
        }
        if (line1.checkPointPosition(new MyPoint(2, -1)) == Line.ON_LINE) {
            System.out.println("Point is on line");
        }
    }
}