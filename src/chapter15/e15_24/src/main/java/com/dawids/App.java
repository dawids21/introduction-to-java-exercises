package com.dawids;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var pane = new Pane();
        var arc = new Arc(320, 240, 240, 100, 210, 120);
        var circle = new Circle(40);
        var transition = new PathTransition(Duration.millis(2000), arc, circle);
        var fading = new FadeTransition();

        circle.setFill(Color.VIOLET);
        circle.setStroke(Color.BLACK);
        circle.setOnMousePressed(event -> {
            transition.pause();
            fading.pause();
        });
        circle.setOnMouseReleased(event -> {
            transition.play();
            fading.play();
        });

        arc.setFill(Color.WHITE);
        arc.setStroke(Color.BLACK);
        arc.setType(ArcType.OPEN);

        transition.setAutoReverse(true);
        transition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transition.setCycleCount(Animation.INDEFINITE);

        fading.setNode(circle);
        fading.setFromValue(0.1);
        fading.setToValue(1);
        fading.setDuration(new Duration(transition.getDuration().toMillis() / 2));
        fading.setCycleCount(Animation.INDEFINITE);
        fading.setAutoReverse(true);

        pane.getChildren().addAll(arc, circle);
        var scene = new Scene(pane, 640, 480);
        stage.setScene(scene);
        stage.show();
        transition.play();
        fading.play();
    }

    public static void main(String[] args) {
        launch();
    }

}