package dawids21;

public class Maze {
    private final TypesOfCells[][] layout = new TypesOfCells[8][8];

    public Maze() {
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[0].length; j++) {
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
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[0].length; j++) {
                if (layout[i][j] == TypesOfCells.OCCUPIED) {
                    layout[i][j] = TypesOfCells.FREE;
                }
            }
        }
    }
}
