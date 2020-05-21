package com.dawids;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var pane = new Pane();
        pane.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                var circle = new Circle(event.getX(), event.getY(), 10, Color.WHITE);
                circle.setStroke(Color.BLACK);
                circle.setOnMouseClicked(eventCircle -> {
                    if (eventCircle.getButton() == MouseButton.SECONDARY) {
                        pane.getChildren().removeIf(n -> n == circle);
                    }
                });
                pane.getChildren().add(circle);
            }
        });
        var scene = new Scene(pane, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}