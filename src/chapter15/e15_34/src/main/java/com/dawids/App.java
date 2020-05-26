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

    @Override
    public void start(Stage stage) {
        var borderPane = new BorderPane();
        var latticePane = new LatticePane(20);
        var control = new RandomWalkControl(20, latticePane);
        var startButton = new Button("Start");

        BorderPane.setAlignment(startButton, Pos.CENTER);

        borderPane.setCenter(latticePane);
        borderPane.setBottom(startButton);
        var scene = new Scene(borderPane, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}