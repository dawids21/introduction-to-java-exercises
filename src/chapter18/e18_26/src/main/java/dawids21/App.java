package dawids21;

import javafx.application.Application;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var gui = new GUI(stage);
        gui.init();
    }

    public static void main(String[] args) {
        launch();
    }

}