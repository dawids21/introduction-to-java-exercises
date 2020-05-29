package com.dawids;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.io.*;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var textArea = new TextArea();
        var labelEnterFile = new Label("Enter a file:");
        var chooseFileTextField = new TextField();
        var topHBox = new HBox(5);
        var saveButton = new Button("Save the change");
        var mainPane = new BorderPane();

        textArea.setWrapText(true);

        labelEnterFile.setAlignment(Pos.CENTER);

        chooseFileTextField.setMaxWidth(Double.MAX_VALUE);
        chooseFileTextField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                try (var inputStream = new BitInputStream(new BufferedInputStream(new FileInputStream(
                        chooseFileTextField.getText())))) {
                    String readByte;
                    StringBuilder readFile = new StringBuilder();
                    while ((readByte = inputStream.readByte()) != null) {
                        readFile.append(readByte);
                    }
                    textArea.setText(readFile.toString());
                    System.out.println("Read complete");
                } catch (FileNotFoundException e) {
                    textArea.setText("File not found");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        HBox.setHgrow(chooseFileTextField, Priority.ALWAYS);
        topHBox.setAlignment(Pos.CENTER);
        topHBox.getChildren().add(labelEnterFile);
        topHBox.getChildren().add(chooseFileTextField);
        topHBox.setPadding(new Insets(5));

        BorderPane.setAlignment(saveButton, Pos.CENTER);
        saveButton.setOnAction(event -> {
            try (var outputStream = new BitOutputStream(new BufferedOutputStream(new FileOutputStream(
                    chooseFileTextField.getText())))) {
                outputStream.writeBit(textArea.getText());
                System.out.println("Write complete");
            } catch (FileNotFoundException e) {
                textArea.setText("File not found");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

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