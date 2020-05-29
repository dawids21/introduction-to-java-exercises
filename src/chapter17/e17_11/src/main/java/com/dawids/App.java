package com.dawids;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;


/**
 * JavaFX App
 */
public class App extends Application {
    public static final double WIDTH = 640;
    public static final double HEIGHT = 480;
    private static final String MAIN_TEXT = "If you split a file named test.txt into 3 smaller files,\nthe three smaller files are test.txt.1, test.txt.2, and test.txt.3.";

    @Override
    public void start(Stage stage) {
        var mainText = new Text(MAIN_TEXT);
        var enterFileLabel = new Label("Enter a file:");
        var specifyNumberLabel = new Label("Specify the number of smaller files:");
        var fileTextField = new TextField();
        var numTextField = new TextField();
        var startButton = new Button("Start");
        var centerPane = new GridPane();
        var mainPane = new BorderPane();

        BorderPane.setAlignment(startButton, Pos.CENTER);
        startButton.setOnAction(event -> splitFile(fileTextField.getText(), Integer.parseInt(numTextField.getText())));

        centerPane.add(mainText, 0, 0, 2, 1);
        centerPane.add(enterFileLabel, 0, 1);
        centerPane.add(fileTextField, 1, 1);
        centerPane.add(specifyNumberLabel, 0, 2);
        centerPane.add(numTextField, 1, 2);
        centerPane.setVgap(5);
        centerPane.setHgap(5);
        centerPane.setPadding(new Insets(5));

        mainPane.setCenter(centerPane);
        mainPane.setBottom(startButton);
        mainPane.setPadding(new Insets(5));

        var scene = new Scene(mainPane);
        stage.setScene(scene);
        stage.show();
    }

    private void splitFile(String fileName, int numberOfPieces) {
        if (numberOfPieces <= 0) {
            System.out.println("You have to specify positive number of pieces");
            return;
        }
        try (var inputStream = new BufferedInputStream(new FileInputStream(getClass().getResource(fileName)
                                                                                     .getFile()))) {
            var sizeOfFiles = inputStream.available() / numberOfPieces;
            for (var i = 1; i <= numberOfPieces; i++) {
                try (var outputStream = new BufferedOutputStream(new FileOutputStream(fileName + "." + i))) {
                    if (i != numberOfPieces) {
                        for (var size = 0; size < sizeOfFiles; size++) {
                            outputStream.write(inputStream.read());
                        }
                    } else {
                        int readValue;
                        while ((readValue = inputStream.read()) != -1) {
                            outputStream.write(readValue);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("You have to specify existing file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

}