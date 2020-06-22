package dawids21;

public class Maze {

    public static final int NUM_OF_ROWS = 8;
    public static final int NUM_OF_COLUMNS = 8;

    public static final Point ENTRY = new Point(0, 0);
    public static final Point EXIT = new Point(7, 7);

    private final TypesOfCells[][] mazeLayout = new TypesOfCells[NUM_OF_ROWS][NUM_OF_COLUMNS];

    public Maze() {
        for (int i = 0; i < NUM_OF_ROWS; i++) {
            for (int j = 0; j < NUM_OF_COLUMNS; j++) {
                mazeLayout[i][j] = TypesOfCells.FREE;
            }
        }
    }

    public void setCellFree(Point point) {
        setCell(point, TypesOfCells.FREE);
    }

    public void setCellOccupied(Point point) {
        setCell(point, TypesOfCells.OCCUPIED);
    }

    public void setCellCrossed(Point point) {
        setCell(point, TypesOfCells.CROSSED);
    }

    private void setCell(Point point, TypesOfCells type) {
        if (point == null) {
            throw new NullPointerException("Cell is null");
        }
        if (type == TypesOfCells.CROSSED) {
            if (point.equals(ENTRY)) {
                throw new IllegalArgumentException("Cant cross entry point");
            }
            if (point.equals(EXIT)) {
                throw new IllegalArgumentException("Cant cross exit point");
            }
        }
        if (!isPointInsideMaze(point)) {
            throw new IllegalArgumentException("Point is not inside maze");
        }
        mazeLayout[point.getX()][point.getY()] = type;
    }

    public boolean isCellFree(Point point) {
        if (point == null) {
            throw new NullPointerException();
        }
        if (!isPointInsideMaze(point)) {
            throw new IllegalArgumentException("Point is not inside maze");
        }
        return mazeLayout[point.getX()][point.getY()] == TypesOfCells.FREE;
    }

    public boolean isCellCrossed(Point point) {
        if (point == null) {
            throw new NullPointerException();
        }
        if (!isPointInsideMaze(point)) {
            throw new IllegalArgumentException("Point is not inside maze");
        }
        return mazeLayout[point.getX()][point.getY()] == TypesOfCells.CROSSED;
    }

    public void clearPath() {
        for (int i = 0; i < NUM_OF_ROWS; i++) {
            for (int j = 0; j < NUM_OF_COLUMNS; j++) {
                if (mazeLayout[i][j] == TypesOfCells.OCCUPIED) {
                    mazeLayout[i][j] = TypesOfCells.FREE;
                }
            }
        }
    }

    public boolean isPointInsideMaze(Point point) {
        return point.getX() >= 0 && point.getX() < NUM_OF_COLUMNS && point.getY() >= 0 && point.getY() < NUM_OF_ROWS;
    }

    private enum TypesOfCells {
        FREE,
        OCCUPIED,
        CROSSED
    }
}
