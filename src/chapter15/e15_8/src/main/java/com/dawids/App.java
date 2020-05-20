package com.dawids;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    //@Override
    //public void start(Stage stage) {
    //    var pane = new Pane();
    //    var text = new Text();
    //    pane.getChildren().add(text);
    //    pane.setOnMouseClicked(event -> {
    //        text.setX(event.getX());
    //        text.setY(event.getY());
    //        text.setText("(" + event.getX() + ", " + event.getY() + ")");
    //    });
    //    var scene = new Scene(pane, 640, 480);
    //    stage.setScene(scene);
    //    stage.show();
    //}

    @Override
    public void start(Stage stage) {

        var pane = new Pane();
        var text = new Text();
        pane.getChildren().add(text);
        pane.setOnMousePressed(event -> {
            text.setX(event.getX());
            text.setY(event.getY());
            text.setText("(" + event.getX() + ", " + event.getY() + ")");
            text.setVisible(true);
        });
        pane.setOnMouseReleased(event -> text.setVisible(false));
        var scene = new Scene(pane, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}