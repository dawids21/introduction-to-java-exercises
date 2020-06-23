package dawids21;

import javafx.application.Application;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    private static final Maze maze = new Maze();

    @Override
    public void start(Stage stage) {
        var gui = new GUI(stage);
        gui.init();
    }

    public static void main(String[] args) {
        launch();
    }

    public static Maze getMaze() {
        return maze;
    }
}