package com.dawids;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;

    @Override
    public void start(Stage stage) {
        var beanMachinePane = new BeanMachinePane(640);
        var scene = new Scene(beanMachinePane, 640, 480);
        var scene = new Scene(mainPane, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}