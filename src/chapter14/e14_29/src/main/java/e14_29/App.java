package e14_29;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class App extends Application {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Polyline polyline = drawPolyline();
        Line[] lines = drawLines();
        Circle[] circles = drawCircle();
        pane.getChildren().add(polyline);
        pane.getChildren().addAll(lines);
        pane.getChildren().addAll(circles);
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Circle[] drawCircle() {
        Circle[] circles = new Circle[28];
        int counter = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j <= i; j++) {
                circles[counter] = new Circle(WIDTH / 2.0 - i * 15 + j * 30, 95 + i * 30, 5);
                circles[counter].setFill(Color.MAROON);
                counter++;
            }
        }
        return circles;
    }

    private Line[] drawLines() {
        Line[] lines = new Line[7];
        double y1 = 340;
        double y2 = 280;
        for (int i = 0; i < 7; i++) {
            double x = WIDTH / 2.0 - 90 + i * 30;
            lines[i] = new Line(x, y1, x, y2);
        }
        return lines;
    }

    private Polyline drawPolyline() {
        double[] points = { WIDTH / 2.0 - 15, 50, WIDTH / 2.0 - 15, 70, WIDTH / 2.0 - 120, 280, WIDTH / 2.0 - 120, 340,
                WIDTH / 2.0 + 120, 340, WIDTH / 2.0 + 120, 280, WIDTH / 2.0 + 15, 70, WIDTH / 2.0 + 15, 50 };
        Polyline polyline = new Polyline(points);
        return polyline;
    }
}
