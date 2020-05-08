package e14_6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class App extends Application {
    private final int NUMBER_OF_SQUARES = 16;
    private final int WIDTH = 800;
    private final int HEIGHT = 800;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane pane = paintCheckerboard();
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane paintCheckerboard() {
        GridPane pane = new GridPane();
        Rectangle[][] cells = new Rectangle[NUMBER_OF_SQUARES][NUMBER_OF_SQUARES];
        for (int i = 0; i < NUMBER_OF_SQUARES; i++) {
            for (int j = 0; j < NUMBER_OF_SQUARES; j++) {
                cells[i][j] = new Rectangle((double) WIDTH / NUMBER_OF_SQUARES, (double) HEIGHT / NUMBER_OF_SQUARES);
                cells[i][j].setStrokeWidth(0);
                if ((i + j) % 2 == 0) {
                    cells[i][j].setFill(Color.WHITE);
                } else {
                    cells[i][j].setFill(Color.BLACK);
                }
                pane.add(cells[i][j], i, j);
            }
        }
        return pane;
    }
}
