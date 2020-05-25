package com.dawids;

import javafx.animation.PathTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * JavaFX App
 */
public class App extends Application {

    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;

    private final BeanMachinePane beanMachinePane = new BeanMachinePane(WIDTH);
    private final BeanMachine beanMachine = new BeanMachine();

    @Override
    public void start(Stage stage) {
        var buttonDrop = new Button("Drop ball");
        var mainPane = new BorderPane();
        var scene = new Scene(mainPane, WIDTH, HEIGHT);

        buttonDrop.setOnAction(event -> dropBall());

        BorderPane.setAlignment(buttonDrop, Pos.CENTER);

        mainPane.setCenter(beanMachinePane);
        mainPane.setBottom(buttonDrop);
        mainPane.setPadding(new Insets(10));

        stage.setScene(scene);
        stage.show();
    }

    private void dropBall() {
        var ball = new Circle(WIDTH / 2.0, -15, 5);
        var positions = beanMachine.simulateFall();
        var animation = makeAnimation(ball, positions);
        ball.setFill(Color.ORANGE);

        beanMachinePane.getChildren().add(ball);
        animation.play();
    }

    private SequentialTransition makeAnimation(Circle ball, int[] positions) {
        var animation = new SequentialTransition(ball);

        var firstFall = new TranslateTransition(Duration.millis(2000), ball);
        firstFall.setByY(100);
        animation.getChildren().add(firstFall);

        for (var row = 0; row < 6; row++) {
            if (positions[row] == positions[row + 1]) {
                animation.getChildren().add(makeCurveFall(ball, row, positions[row], FallDirection.LEFT));
            } else {
                animation.getChildren().add(makeCurveFall(ball, row, positions[row], FallDirection.RIGHT));
            }
        }

        return animation;
    }

    private enum FallDirection {
        RIGHT,
        LEFT;
    }

    private PathTransition makeCurveFall(Circle ball, int row, int position, FallDirection direction) {

        var path = new Arc();
        var pathTransition = new PathTransition(Duration.millis(1000), path, ball);

        return pathTransition;
    }

    public static void main(String[] args) {
        launch();
    }

}