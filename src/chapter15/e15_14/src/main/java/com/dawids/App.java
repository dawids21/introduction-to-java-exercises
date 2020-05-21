package com.dawids;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        double[] points = {40, 20, 70, 40, 60, 80, 45, 45, 20, 60};
        var polygon = new Polygon(points);
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);

        var pane = new Pane();
        pane.getChildren().add(polygon);

        var text = new Text();
        pane.setOnMouseMoved(event -> {
            if (polygon.contains(event.getX(), event.getY())) {
                text.setText("Mouse point is inside the polygon");
            } else {
                text.setText("Mouse point is outside the polygon");
            }
            text.setX(event.getX());
            text.setY(event.getY());
        });
        pane.getChildren().add(text);

        var scene = new Scene(pane, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}