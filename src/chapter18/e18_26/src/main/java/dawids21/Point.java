package dawids21;

import java.util.Objects;

public class Point {

    private int x = 0;
    private int y = 0;

    public Point() {

    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return getX() == point.getX() &&
                getY() == point.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    public void moveUp() {
        y--;
    }

    public void moveDown() {
        y++;
    }
    public void moveLeft() {
        x--;
    }
    public void moveRight() {
        x++;
    }
}
