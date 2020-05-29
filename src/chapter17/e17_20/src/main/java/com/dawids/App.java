package com.dawids;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    private final TextArea textArea = new TextArea();

    @Override
    public void start(Stage stage) {
        var labelEnterFile = new Label("Enter a file:");
        var chooseFileTextField = new TextField();
        var topHBox = new HBox(5);
        var saveButton = new Button("Save the change");
        var mainPane = new BorderPane();

        textArea.setEditable(false);
        textArea.setWrapText(true);

        labelEnterFile.setAlignment(Pos.CENTER);

        chooseFileTextField.setMaxWidth(Double.MAX_VALUE);

        HBox.setHgrow(chooseFileTextField, Priority.ALWAYS);
        topHBox.setAlignment(Pos.CENTER);
        topHBox.getChildren().add(labelEnterFile);
        topHBox.getChildren().add(chooseFileTextField);
        topHBox.setPadding(new Insets(5));

        BorderPane.setAlignment(saveButton, Pos.CENTER);

        mainPane.setTop(topHBox);
        mainPane.setCenter(textArea);
        mainPane.setBottom(saveButton);
        BorderPane.setMargin(saveButton, new Insets(5));

        var scene = new Scene(mainPane, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}