package com.dawids;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var borderPane = new BorderPane();

        var buttons = new Button[4];
        buttons[0] = new Button("Left");
        buttons[1] = new Button("Right");
        buttons[2] = new Button("Up");
        buttons[3] = new Button("Down");

        var hButtonBox = new HBox();
        hButtonBox.getChildren().addAll(buttons);
        hButtonBox.setAlignment(Pos.CENTER);
        hButtonBox.setPadding(new Insets(10));
        hButtonBox.setSpacing(5);
        borderPane.setBottom(hButtonBox);

        var circlePane = new CirclePane();
        borderPane.setCenter(circlePane);

        buttons[0].setOnAction(event -> circlePane.moveCircleLeft());
        buttons[1].setOnAction(event -> circlePane.moveCircleRight());
        buttons[2].setOnAction(event -> circlePane.moveCircleUp());
        buttons[3].setOnAction(event -> circlePane.moveCircleDown());

        var scene = new Scene(borderPane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}