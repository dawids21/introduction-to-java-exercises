package chapter10.LineSegment;

public class TestLineSegment {
    public static void main(String[] args) {
        LineSegment mainLine = new LineSegment(1, 3, 3, 1);
        LineSegment[] lines = new LineSegment[4];
        lines[0] = new LineSegment(-1, 5, 0, 4);
        lines[1] = new LineSegment(2, 4, 4, 5);
        lines[2] = new LineSegment(1, 1, 4, 4);
        lines[3] = new LineSegment(2, 2, 4, 1);
        for (int i = 0; i < lines.length; i++) {
            if (mainLine.isIntersecting(lines[i])) {
                System.out.println("Is intersecting");
            }
            else {
                System.out.println("Is not intersecting");
            }
        }
    }    
}