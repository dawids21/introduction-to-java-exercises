package dawids21;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MazeSolverTest {

    @Nested
    class MazeTest {
        Maze maze;

        @BeforeEach
        void setUp() {
            maze = new Maze();
        }

        @Test
        @DisplayName("Set cell inside maze")
        void testSetCell() {
            var point = new Point(1, 1);
            maze.setCellOccupied(point);
            assertTrue(maze.isCellOccupied(point));
        }

        @Test
        @DisplayName("New Maze should have all cells free")
        void testInitMaze() {
            for (var i = 0; i < Maze.NUM_OF_COLUMNS; i++) {
                for (var j = 0; j < Maze.NUM_OF_ROWS; j++) {
                    assertTrue(maze.isCellFree(new Point(i, j)));
                }
            }
        }
    }
}