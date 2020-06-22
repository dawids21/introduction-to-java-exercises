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

        @Test
        void testNullCell() {
            assertAll(() -> assertThrows(NullPointerException.class, () -> maze.setCellCrossed(null)),
                      () -> assertThrows(NullPointerException.class, () -> maze.setCellOccupied(null)),
                      () -> assertThrows(NullPointerException.class, () -> maze.setCellFree(null))
            );
        }
    }

    @Test
    @DisplayName("Should return return path from ENTRY to EXIT")
    void testSolver() {
        var maze = new Maze();
        final Point[] crossedPoints = {
                new Point(1, 1),
                new Point(5, 1),
                new Point(3, 2),
                new Point(6, 3),
                new Point(2, 4),
                new Point(4, 4),
                new Point(4, 6),
                new Point(1, 7)
        };
        for (Point point : crossedPoints) {
            maze.setCellCrossed(point);
        }
        var head = new Point(Maze.ENTRY.getX(), Maze.ENTRY.getY());
        var path = Solver.findPath(maze);
        for (Directions move : path) {
            switch (move) {
                case UP:
                    head.moveUp();
                    break;
                case DOWN:
                    head.moveDown();
                    break;
                case LEFT:
                    head.moveLeft();
                    break;
                case RIGHT:
                    head.moveRight();
                    break;
            }
        }
        assertEquals(Maze.EXIT, head);
    }
}
