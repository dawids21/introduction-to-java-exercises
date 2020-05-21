package com.dawids;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    private double positionX = 50;
    private double positionY = 50;

    @Override
    public void start(Stage stage) {
        var pane = new Pane();
        var scene = new Scene(pane, 640, 480);
        var polyline = new Polyline();
        polyline.getPoints().addAll(positionX, positionY);
        pane.getChildren().add(polyline);
        pane.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    positionY -= 20;
                    break;
                case DOWN:
                    positionY += 20;
                    break;
                case LEFT:
                    positionX -= 20;
                    break;
                case RIGHT:
                    positionX += 20;
                    break;
                default:
                    return;
            }
            polyline.getPoints().addAll(positionX, positionY);
        });
        stage.setScene(scene);
        stage.show();
        pane.requestFocus();
    }

    public static void main(String[] args) {
        launch();
    }

}