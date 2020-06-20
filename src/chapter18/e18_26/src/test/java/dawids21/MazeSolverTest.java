package dawids21;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MazeSolverTest {

    @Nested
    class MazeTest {
        Maze maze;

        @BeforeEach
        void setUp() {
            maze = new Maze();
        }

        @Test
        @DisplayName("New Maze should have all cells free")
        void testInitMaze() {
            TypesOfCells[][] expected = new TypesOfCells[8][8];
            for (var i = 0; i < Maze.NUM_OF_COLUMNS; i++) {
                for (var j = 0; j < Maze.NUM_OF_ROWS; j++) {
                    expected[i][j] = TypesOfCells.FREE;
                }
            }
            TypesOfCells[][] actual = maze.getMazeLayout();
            for (var i = 0; i < Maze.NUM_OF_COLUMNS; i++) {
                for (var j = 0; j < Maze.NUM_OF_ROWS; j++) {
                    assertEquals(expected[i][j], actual[i][j]);
                }
            }
        }
    }
}