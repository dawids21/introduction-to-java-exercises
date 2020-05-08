package e14_14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane pane = new Pane();
        Rectangle[] rectangles = getRectangles(pane, 100, 40, 40, 120);
        Line[] lines = getLines(rectangles[0], rectangles[1]);
        pane.getChildren().addAll(rectangles);
        pane.getChildren().addAll(lines);
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Rectangle[] getRectangles(Pane pane, int rc1X, int rc1Y, int rc2X, int rc2Y) {
        Rectangle[] rectangles = new Rectangle[2];
        rectangles[0] = new Rectangle();
        rectangles[1] = new Rectangle();

        rectangles[0].setX(rc1X);
        rectangles[0].setY(rc1Y);
        rectangles[0].widthProperty().bind(pane.widthProperty().subtract(1.5 * rectangles[0].getX()));
        rectangles[0].heightProperty().bind(rectangles[1].heightProperty());
        rectangles[0].setStroke(Color.BLACK);
        rectangles[0].setFill(null);

        rectangles[1].setX(40);
        rectangles[1].setY(120);
        rectangles[1].widthProperty().bind(rectangles[0].widthProperty());
        rectangles[1].heightProperty().bind(pane.heightProperty().subtract(1.5 * rectangles[1].getY()));
        rectangles[1].setStroke(Color.BLACK);
        rectangles[1].setFill(null);

        return rectangles;
    }

    private Line[] getLines(Rectangle rc1, Rectangle rc2) {
        Line[] lines = new Line[4];

        lines[0] = new Line(rc1.getX(), rc1.getY(), rc2.getX(), rc2.getY());

        lines[1] = new Line();
        lines[1].startXProperty().bind(rc1.widthProperty().add(rc1.getX()));
        lines[1].setStartY(rc1.getY());
        lines[1].endXProperty().bind(rc2.widthProperty().add(rc2.getX()));
        lines[1].setEndY(rc2.getY());

        lines[2] = new Line();
        lines[2].setStartX(rc1.getX());
        lines[2].startYProperty().bind(rc1.heightProperty().add(rc1.getY()));
        lines[2].setEndX(rc2.getX());
        lines[2].endYProperty().bind(rc2.heightProperty().add(rc2.getY()));

        lines[3] = new Line();
        lines[3].startXProperty().bind(rc1.widthProperty().add(rc1.getX()));
        lines[3].startYProperty().bind(rc1.heightProperty().add(rc1.getY()));
        lines[3].endXProperty().bind(rc2.widthProperty().add(rc2.getX()));
        lines[3].endYProperty().bind(rc2.heightProperty().add(rc2.getY()));

        return lines;
    }
}
