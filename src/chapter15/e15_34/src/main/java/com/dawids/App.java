package com.dawids;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    private final BorderPane borderPane = new BorderPane();

    @Override
    public void start(Stage stage) {
        var latticePane = new LatticePane(20);
        var startButton = new Button("Start");

        startButton.setOnAction(event -> startRandomWalk());

        BorderPane.setAlignment(startButton, Pos.CENTER);

        borderPane.setCenter(latticePane);
        borderPane.setBottom(startButton);
        var scene = new Scene(borderPane, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    private void startRandomWalk() {
        var latticePane = new LatticePane(20);
        var control = new RandomWalkControl(20, latticePane);
        borderPane.setCenter(latticePane);
        while (true) {
            try {
                control.makeMove();
            } catch (NoMoreMoveException e) {
                if (e.isReachBoundary()) {
                    System.out.println("Success");
                } else {
                    System.out.println("Failure");
                }
                break;
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }

}