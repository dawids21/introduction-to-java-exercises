package dawids21;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeSolverTest {

    @Nested
    @DisplayName("Test Maze class")
    class MazeTest {
        Maze maze;

        @BeforeEach
        void setUp() {
            maze = new Maze();
        }

        @Test
        @DisplayName("Cell is not free after setting as occupied")
        void testSetCellOccupied() {
            var point = new Point(1, 1);
            maze.setCellOccupied(point);
            assertFalse(maze.isCellFree(point));
        }

        @Test
        @DisplayName("Cell is free after setting as free")
        void testSetCellFree() {
            var point = new Point(1, 1);
            maze.setCellFree(point);
            assertTrue(maze.isCellFree(point));
        }

        @Test
        @DisplayName("Cell is not free after setting as crossed")
        void testSetCellCrossed() {
            var point = new Point(1, 1);
            maze.setCellCrossed(point);
            assertFalse(maze.isCellFree(point));
        }

        @Test
        void testClearPath() {
            var occupiedPoint = new Point(1, 1);
            var crossedPoint = new Point(1, 2);
            maze.setCellOccupied(occupiedPoint);
            maze.setCellCrossed(crossedPoint);
            maze.clearPath();
            assertAll(() -> assertTrue(maze.isCellFree(occupiedPoint)),
                      () -> assertFalse(maze.isCellFree(crossedPoint)));
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

        @Test
        @DisplayName("Should not be possible to set cell outside the maze")
        void testSetCellOutOfBound() {
            assertAll(() -> assertThrows(IllegalArgumentException.class, () -> maze.setCellOccupied(new Point(-1, 2))),
                      () -> assertThrows(IllegalArgumentException.class, () -> maze.setCellOccupied(new Point(9, 2))),
                      () -> assertThrows(IllegalArgumentException.class, () -> maze.setCellOccupied(new Point(1, -2))),
                      () -> assertThrows(IllegalArgumentException.class, () -> maze.setCellOccupied(new Point(1, 9))),
                      () -> assertThrows(IllegalArgumentException.class, () -> maze.setCellCrossed(new Point(-1, 2))),
                      () -> assertThrows(IllegalArgumentException.class, () -> maze.setCellCrossed(new Point(9, 2))),
                      () -> assertThrows(IllegalArgumentException.class, () -> maze.setCellCrossed(new Point(1, -2))),
                      () -> assertThrows(IllegalArgumentException.class, () -> maze.setCellCrossed(new Point(1, 9))),
                      () -> assertThrows(IllegalArgumentException.class, () -> maze.setCellFree(new Point(-1, 2))),
                      () -> assertThrows(IllegalArgumentException.class, () -> maze.setCellFree(new Point(9, 2))),
                      () -> assertThrows(IllegalArgumentException.class, () -> maze.setCellFree(new Point(1, -2))),
                      () -> assertThrows(IllegalArgumentException.class, () -> maze.setCellFree(new Point(1, 9)))
            );
        }

        @Test
        @DisplayName("Should not be possible to cross entry point")
        void testSetEntryPoint() {
            assertThrows(IllegalArgumentException.class, () -> maze.setCellCrossed(new Point(0, 0)));
        }

        @Test
        @DisplayName("Should not be possible to cross exit point")
        void testSetExitPoint() {
            assertThrows(IllegalArgumentException.class, () -> maze.setCellCrossed(new Point(7, 7)));
        }

    }
}