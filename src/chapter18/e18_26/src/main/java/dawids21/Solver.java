package dawids21;

public class Solver {

    private final Point head = new Point();
    private final Maze mazeLayout;

    public Solver() {
        mazeLayout = new Maze();
    }

    public Solver(Maze mazeLayout) {
        this.mazeLayout = mazeLayout;
    }
}
