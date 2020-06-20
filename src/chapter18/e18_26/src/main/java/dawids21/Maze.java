package dawids21;

public class Maze {

    public static final int NUM_OF_ROWS = 8;
    public static final int NUM_OF_COLUMNS = 8;

    private final TypesOfCells[][] mazeLayout = new TypesOfCells[NUM_OF_ROWS][NUM_OF_COLUMNS];

    public Maze() {
        for (int i = 0; i < NUM_OF_ROWS; i++) {
            for (int j = 0; j < NUM_OF_COLUMNS; j++) {
                mazeLayout[i][j] = TypesOfCells.FREE;
            }
        }
    }

    public void setCell(Point point, TypesOfCells type) {
        if (point.getX() < 0 || point.getX() >= NUM_OF_COLUMNS) {
            throw new IllegalArgumentException("X coordinate is out of bound");
        }
        if (point.getY() < 0 || point.getY() >= NUM_OF_ROWS) {
            throw new IllegalArgumentException("Y coordinate is out of bound");
        }
        mazeLayout[point.getX()][point.getY()] = type;
    }

    public TypesOfCells getCell(Point point) {
        if (point.getX() < 0 || point.getX() >= NUM_OF_COLUMNS) {
            throw new IllegalArgumentException("X coordinate is out of bound");
        }
        if (point.getY() < 0 || point.getY() >= NUM_OF_ROWS) {
            throw new IllegalArgumentException("Y coordinate is out of bound");
        }
        return mazeLayout[point.getX()][point.getY()];
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

    public TypesOfCells[][] getMazeLayout() {
        return mazeLayout;
    }
}
