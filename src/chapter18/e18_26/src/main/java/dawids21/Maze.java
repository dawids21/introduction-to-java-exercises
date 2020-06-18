package dawids21;

import javafx.geometry.Point2D;

class Maze {
    private TypesOfCells[][] layout = new TypesOfCells[8][8];

    Maze() {
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[0].length; j++) {
                layout[i][j] = TypesOfCells.FREE;
            }
        }
    }

    void setCell(Point2D point, TypesOfCells type) {
        layout[(int) point.getX()][(int) point.getY()] = type;
    }

    TypesOfCells getCell(Point2D point) {
        return layout[(int) point.getX()][(int) point.getY()];
    }
}
