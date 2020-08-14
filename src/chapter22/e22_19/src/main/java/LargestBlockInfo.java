import java.util.Objects;

public class LargestBlockInfo {

    private final int x;
    private final int y;
    private final int size;

    public LargestBlockInfo(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LargestBlockInfo that = (LargestBlockInfo) o;
        return getX() == that.getX() && getY() == that.getY() &&
               getSize() == that.getSize();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY(), getSize());
    }

    @Override
    public String toString() {
        return "LargestBlockInfo{" + "x=" + x + ", y=" + y + ", size=" + size + '}';
    }
}
