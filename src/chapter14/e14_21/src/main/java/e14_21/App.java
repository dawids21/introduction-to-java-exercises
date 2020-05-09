package e14_21;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Circle[] circles = drawCircles(2);
        Line line = new Line(circles[0].getCenterX(), circles[0].getCenterY(), circles[1].getCenterX(),
                circles[1].getCenterY());
        Text distanceText = new Text();
        double distance = Math
                .sqrt(Math.pow(line.getEndX() - line.getStartX(), 2) + Math.pow(line.getEndY() - line.getStartY(), 2));
        distanceText.setText(String.valueOf(distance));
        distanceText.setX((line.getStartX() + line.getEndX()) / 2.0);
        distanceText.setY((line.getStartY() + line.getEndY()) / 2.0);
        Pane pane = new Pane();
        pane.getChildren().addAll(line, circles[0], circles[1], distanceText);
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Circle[] drawCircles(int num) {
        Circle[] circles = new Circle[num];
        for (int i = 0; i < num; i++) {
            circles[i] = new Circle(20 + Math.random() * (WIDTH - 40), 20 + Math.random() * (HEIGHT - 40), 15);
        }
        return circles;
    }
}
