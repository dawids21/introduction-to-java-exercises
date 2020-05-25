package com.dawids;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;

    @Override
    public void start(Stage stage) {
        var beanMachinePane = new BeanMachinePane(WIDTH);
        var beanMachine = new BeanMachine();
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
    }

    public static void main(String[] args) {
        launch();
    }

}