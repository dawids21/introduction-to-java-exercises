package com.dawids;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var labels = new HashMap<Fields, Label>();
        //todo center labels vertically
        var textFields = new HashMap<Fields, TextField>();
        for (Fields field : Fields.values()) {
            labels.put(field, new Label(field.getLabel()));
            textFields.put(field, new TextField());
        }
        var hBoxes = new HBox[4];
        hBoxes[0] = new HBox(labels.get(Fields.NAME), textFields.get(Fields.NAME));
        hBoxes[1] = new HBox(labels.get(Fields.STREET), textFields.get(Fields.STREET));
        hBoxes[2] = new HBox(labels.get(Fields.CITY),
                             textFields.get(Fields.CITY),
                             labels.get(Fields.STATE),
                             textFields.get(Fields.STATE),
                             labels.get(Fields.ZIP),
                             textFields.get(Fields.ZIP));
        hBoxes[3] = new HBox();
        var vBox = new VBox();

        hBoxes[0] = new HBox(labels.get(Fields.NAME), textFields.get(Fields.NAME));
        hBoxes[0].setSpacing(5);
        hBoxes[0].setAlignment(Pos.CENTER);
        hBoxes[1] = new HBox(labels.get(Fields.STREET), textFields.get(Fields.STREET));
        hBoxes[1].setSpacing(5);
        hBoxes[1].setAlignment(Pos.CENTER);
        hBoxes[2] = new HBox(labels.get(Fields.CITY),
                             textFields.get(Fields.CITY),
                             labels.get(Fields.STATE),
                             textFields.get(Fields.STATE),
                             labels.get(Fields.ZIP),
                             textFields.get(Fields.ZIP));
        hBoxes[2].setSpacing(5);
        hBoxes[2].setAlignment(Pos.CENTER);
        hBoxes[3] = new HBox();
        hBoxes[3].setSpacing(5);
        hBoxes[3].setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(hBoxes);
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(10));

        HBox.setHgrow(textFields.get(Fields.NAME), Priority.ALWAYS);
        HBox.setHgrow(textFields.get(Fields.STREET), Priority.ALWAYS);
        textFields.get(Fields.STATE).setPrefColumnCount(2);
        textFields.get(Fields.ZIP).setPrefColumnCount(5);

        var scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }

    private enum Fields {
        NAME("Name"),
        STREET("Street"),
        CITY("City"),
        STATE("State"),
        ZIP("Zip");

        private final String label;

        Fields(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

    private enum Buttons {
        ADD("Add"),
        FIRST("First"),
        NEXT("Next"),
        PREV("Previous"),
        LAST("Last"),
        UPDATE("Update");

        private final String label;

        Buttons(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

    public static void main(String[] args) {
        launch();
    }

}