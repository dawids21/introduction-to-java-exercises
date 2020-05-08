package e14_9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
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

    private void getArcs(StackPane stackPane) {
        double angle = 30;
        for (int i = 0; i < 4; i++) {
            Arc arc = new Arc(100, 100, 80, 80, 90 * i + angle, 30);
            Pane pane = new Pane(arc);
            arc.setType(ArcType.ROUND);
            stackPane.getChildren().add(pane);
        }
    }

    private Circle getCircle() {
        Circle circle = new Circle(100);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        return circle;
    }
}
