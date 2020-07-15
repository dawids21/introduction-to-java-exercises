package dawidstasiak;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.LinkedList;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        ObservableList<Integer> list = FXCollections.observableList(new LinkedList<>());
        var enterValueBox = new HBox();
        var enterValueTextField = new TextField();
        enterValueTextField.setAlignment(Pos.CENTER_LEFT);
        enterValueTextField.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                list.add(Integer.valueOf(enterValueTextField.getText()));
                enterValueTextField.clear();
            }
        });
        enterValueBox.getChildren().add(new Label("Enter a number:"));
        enterValueBox.getChildren().add(enterValueTextField);
        enterValueBox.setAlignment(Pos.CENTER);
        enterValueBox.setSpacing(10);

        var mainTextArea = new TextArea();
        mainTextArea.setEditable(false);
        mainTextArea.setWrapText(true);
        list.addListener((ListChangeListener<Integer>) change -> {
            var str = new StringBuilder();
            for (var value: list) {
                str.append(value);
                str.append(" ");
            }
            mainTextArea.setText(str.toString());
        });

        var buttonBox = new HBox();
        buttonBox.setSpacing(10);
        buttonBox.setAlignment(Pos.CENTER);
        var sortButton = new Button("Sort");
        sortButton.setOnAction(event -> Collections.sort(list));
        var shuffleButton = new Button("Shuffle");
        shuffleButton.setOnAction(event -> Collections.shuffle(list));
        var reverseButton = new Button("Reverse");
        reverseButton.setOnAction(event -> Collections.reverse(list));
        buttonBox.getChildren().add(sortButton);
        buttonBox.getChildren().add(shuffleButton);
        buttonBox.getChildren().add(reverseButton);

        var mainPane = new BorderPane();
        mainPane.setTop(enterValueBox);
        mainPane.setCenter(mainTextArea);
        mainPane.setBottom(buttonBox);
        var mainScene = new Scene(mainPane, 400, 400);
        stage.setScene(mainScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}