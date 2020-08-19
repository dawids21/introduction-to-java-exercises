import java.util.Objects;

public class Pair implements Comparable<Pair> {

    private final Point2D p1;
    private final Point2D p2;

    public Pair(Point2D p1, Point2D p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point2D getP1() {
        return p1;
    }

    public Point2D getP2() {
        return p2;
    }

    public double getDistance() {
        return Math.sqrt(Math.pow(getP1().getX() - getP2().getX(), 2) +
                         Math.pow(getP1().getY() - getP2().getY(), 2));
    }

    @Override
    public int compareTo(Pair pair) {
        return Double.compare(getDistance(), pair.getDistance());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair pair = (Pair) o;
        return Objects.equals(getP1(), pair.getP1()) &&
               Objects.equals(getP2(), pair.getP2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getP1(), getP2());
    }
}
