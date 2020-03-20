package chapter10.LineSegment;

import chapter10.Line.Line;
import chapter10.MyPoint.MyPoint;

public class LineSegment {
    private MyPoint startPoint;
    private MyPoint endPoint;
	public LineSegment(MyPoint startPoint, MyPoint endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
    
    public LineSegment(double x1, double y1, double x2, double y2) {
        this(new MyPoint(x1, y1), new MyPoint(x2, y2));
    }

    public double getLineLength() {
        return startPoint.getDistance(endPoint);
    }

    public boolean isIntersecting(LineSegment line) {
        boolean intersecting = false;
        Line lineEquation = new Line(this);
        int startPointPosition = lineEquation.checkPointPosition(line.getStartPoint());
        int endPointPosition = lineEquation.checkPointPosition(line.getEndPoint());

        if (startPointPosition != endPointPosition) {
            intersecting = true;
        }
        else if (startPointPosition == Line.ON_LINE) {
            if (isPointOnSegment(line.getStartPoint())
                || isPointOnSegment(line.getEndPoint())) {
                intersecting = true;
            }
        }

        return intersecting;
    }

    public MyPoint getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(MyPoint startPoint) {
        this.startPoint = startPoint;
    }

    public MyPoint getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(MyPoint endPoint) {
        this.endPoint = endPoint;
    }

    public boolean isPointOnSegment(MyPoint point) {
        boolean pointOnSegment = false;
        if (point.getX() <= Math.max(getStartPoint().getX(), getEndPoint().getX())
            && point.getX() >= Math.min(getStartPoint().getX(), getEndPoint().getX())
            && point.getY() <= Math.max(getStartPoint().getY(), getEndPoint().getY())
            && point.getY() >= Math.min(getStartPoint().getY(), getEndPoint().getY())) {
                pointOnSegment = true;
            }
        return pointOnSegment;
    }
}