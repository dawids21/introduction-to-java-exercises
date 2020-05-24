package com.dawids;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
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
        var animation = new PathTransition(Duration.millis(2000), arc, circle);

        circle.setFill(Color.VIOLET);
        circle.setStroke(Color.BLACK);
        circle.setOnMousePressed(event -> animation.pause());
        circle.setOnMouseReleased(event -> animation.play());

        arc.setFill(Color.WHITE);
        arc.setStroke(Color.BLACK);
        arc.setType(ArcType.OPEN);

        animation.setAutoReverse(true);
        animation.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        animation.setCycleCount(Animation.INDEFINITE);
        animation.setInterpolator(Interpolator.LINEAR);

        pane.getChildren().addAll(arc, circle);
        var scene = new Scene(pane, 640, 480);
        stage.setScene(scene);
        stage.show();
        animation.play();
    }

    public static void main(String[] args) {
        launch();
    }

}