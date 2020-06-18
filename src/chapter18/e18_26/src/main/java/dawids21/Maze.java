package dawids21;

class Maze {
    private TypesOfCells[][] layout = new TypesOfCells[8][8];

    Maze() {
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[0].length; j++) {
                layout[i][j] = TypesOfCells.FREE;
            }
        }
    }
}
