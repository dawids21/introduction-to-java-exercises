package chapter10.MyPoint;

public class TestMyPoint {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint(0, 3);
        MyPoint p2 = new MyPoint(4, 0);
        System.out.println("Distance: " + p1.getDistance(p2));
    }    
}