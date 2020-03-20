package chapter10.Triangle2D;

import chapter10.MyPoint.MyPoint;

public class TestTriangle2D {
    public static void main(String[] args) {
        Triangle2D t1 = new Triangle2D( new MyPoint(2.5, 2),
                                        new MyPoint(4.2, 3),
                                        new MyPoint(5, 3.5));
        System.out.println("Area: " + t1.getArea());
        System.out.println("Perimeter: " + t1.getPerimeter());
        System.out.println("Is triangle contain (3, 3)? " + (t1.contains(3.0, 3.0) ? true : false));
        System.out.println("Is triangle contain another triangle? "
                            + t1.contains(new Triangle2D(  new MyPoint(2.9, 2),
                                                            new MyPoint(4, 1),
                                                            new MyPoint(1, 3.4))));
        System.out.println("Is triangle overlap another triangle? "
                            + t1.overlaps(new Triangle2D(   new MyPoint(2, 5.5),
                                                            new MyPoint(4, -3),
                                                            new MyPoint(2, 6.5))));
        
    }    
}