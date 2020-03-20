package chapter10.Triangle2D;

import chapter10.LineSegment.LineSegment;
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

	public double getPerimeter() {
        double perimeter = 0;
        perimeter = p1.getDistance(p2) + p1.getDistance(p3) + p2.getDistance(p3);
		return perimeter;
	}

	public boolean contains(Triangle2D triangle2d) {
        boolean contain = false;
        if (contains(triangle2d.p1) && contains(triangle2d.p2) && contains(triangle2d.p3)) {
            contain = true;
        }
		return contain;
	}

	public boolean contains(double d, double e) {
		return contains(new MyPoint(d, e));
    }
    
    public boolean contains(MyPoint point) {
        boolean contain = true;
        LineSegment[] sides = new LineSegment[3];
        sides[0] = new LineSegment(p2, p3);
        sides[1] = new LineSegment(p1, p3);
        sides[2] = new LineSegment(p1, p2);
        LineSegment[] lines = new LineSegment[3];
        lines[0] = new LineSegment(point, p1);
        lines[1] = new LineSegment(point, p2);
        lines[2] = new LineSegment(point, p3);

        for (int i = 0; i < sides.length; i++) {
            if (lines[i].isIntersecting(sides[i])) {
                contain = false;
                break;
            }
        }

		return contain;
	}

	public boolean overlaps(Triangle2D triangle2d) {
		boolean overlap = false;
        if (!contains(triangle2d.p1) || !contains(triangle2d.p2) || !contains(triangle2d.p3)
            && !triangle2d.contains(this)) {
            overlap = true;
        }
		return overlap;
	}
    
}