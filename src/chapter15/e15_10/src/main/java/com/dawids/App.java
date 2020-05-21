package com.dawids;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var stackPane = new StackPane();
        var scene = new Scene(stackPane, 640, 480);
        var inputText = new StringBuilder();
        var text = new Text();
        stackPane.setOnKeyTyped(event -> {
            var inputCharacter = event.getCharacter().charAt(0);
            if (Character.isLetterOrDigit(inputCharacter)) {
                inputText.append(inputCharacter);
                text.setText(inputText.toString());
            }
        });
        stackPane.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                inputText.delete(0, inputText.length());
            } else if (event.getCode() == KeyCode.BACK_SPACE && inputText.length() > 0) {
                inputText.deleteCharAt(inputText.length() - 1);
                text.setText(inputText.toString());
            }
        });
        stackPane.getChildren().add(text);
        stage.setScene(scene);
        stage.show();
        stackPane.requestFocus();
    }

    public static void main(String[] args) {
        launch();
    }

}