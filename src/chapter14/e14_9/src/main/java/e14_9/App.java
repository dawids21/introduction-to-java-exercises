package e14_9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane mainPane = new GridPane();
        mainPane.setPadding(new Insets(10, 10, 10, 10));
        mainPane.setHgap(10);
        mainPane.setVgap(10);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                StackPane circlePane = new StackPane();
                Circle circle = getCircle();
                circlePane.getChildren().add(circle);
                getArcs(circlePane);
                mainPane.add(circlePane, j, i);
            }
        }
        Scene scene = new Scene(mainPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void getArcs(StackPane pane) {
        Arc arc = new Arc();
        pane.getChildren().add(arc);
    }

    private Circle getCircle() {
        Circle circle = new Circle(100);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        return circle;
    }
}
