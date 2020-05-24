package com.dawids;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var car = drawCar();
        var pane = new Pane(car);
        var path = new Line(50, 450, 590, 450);
        var animation = new PathTransition(Duration.millis(5000), path, car);
        animation.setCycleCount(Animation.INDEFINITE);
        animation.setInterpolator(Interpolator.LINEAR);

        car.setOnMousePressed(event -> animation.pause());
        car.setOnMouseReleased(event -> animation.play());

        pane.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    animation.setRate(animation.getRate() + 1);
                    break;
                case DOWN:
                    animation.setRate(animation.getRate() > 0 ? animation.getRate() - 1 : 0);
                    break;
            }
        });

        var scene = new Scene(pane, 640, 480);
        stage.setScene(scene);
        stage.show();
        animation.play();
        pane.requestFocus();
    }

    private Group drawCar() {
        var wheelFront = new Circle(30, 50, 10);
        var wheelBack = new Circle(70, 50, 10);
        var body = new Rectangle(0, 20, 100, 20);
        var roof = new Polygon(20, 20, 80, 20, 60, 0, 40, 0);

        body.setFill(Color.RED);

        roof.setFill(Color.LIGHTBLUE);

        return new Group(wheelFront, wheelBack, body, roof);
    }

    public static void main(String[] args) {
        launch();
    }

}