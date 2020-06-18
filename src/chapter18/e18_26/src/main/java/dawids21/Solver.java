package dawids21;

class Solver {

    private final Point head = new Point();
    private final Maze mazeLayout;

    Solver() {
        mazeLayout = new Maze();
    }

    Solver(Maze mazeLayout) {
        this.mazeLayout = mazeLayout;
    }
}
