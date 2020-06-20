package dawids21;

public class Maze {

    public static final int NUM_OF_ROWS = 8;
    public static final int NUM_OF_COLUMNS = 8;

    private final TypesOfCells[][] layout = new TypesOfCells[NUM_OF_ROWS][NUM_OF_COLUMNS];

    public Maze() {
        for (int i = 0; i < NUM_OF_ROWS; i++) {
            for (int j = 0; j < NUM_OF_COLUMNS; j++) {
                layout[i][j] = TypesOfCells.FREE;
            }
        }
    }

    public void setCell(Point point, TypesOfCells type) {
        layout[point.getX()][point.getY()] = type;
    }

    public TypesOfCells getCell(Point point) {
        return layout[point.getX()][point.getY()];
    }

    public void clearPath() {
        for (int i = 0; i < NUM_OF_ROWS; i++) {
            for (int j = 0; j < NUM_OF_COLUMNS; j++) {
                if (layout[i][j] == TypesOfCells.OCCUPIED) {
                    layout[i][j] = TypesOfCells.FREE;
                }
            }
        }
    }
}
