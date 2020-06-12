package com.dawids;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;


/**
 * JavaFX App
 */
public class App extends Application {

    private static final String FILE_NAME = "AddressBook.dat";
    private static final int PERSON_SIZE = 32 + 32 + 20 + 2 + 5;

    private final HashMap<Fields, TextField> textFields = new HashMap<>();
    private static long index = -1;

    @Override
    public void start(Stage stage) {
        var labels = new HashMap<Fields, Label>();
        for (Fields field : Fields.values()) {
            labels.put(field, new Label(field.getLabel()));
            textFields.put(field, new TextField());
        }
        var buttons = new HashMap<Buttons, Button>();
        for (Buttons button : Buttons.values()) {
            buttons.put(button, new Button(button.getLabel()));
        }
        var hBoxes = new HBox[4];
        var vBox = new VBox();

        buttons.get(Buttons.ADD).setOnAction(event -> {
            var person = new Person(textFields.get(Fields.NAME).getText(),
                                    textFields.get(Fields.STREET).getText(),
                                    textFields.get(Fields.CITY).getText(),
                                    textFields.get(Fields.STATE).getText(),
                                    textFields.get(Fields.ZIP).getText());
            try (var outputFile = new RandomAccessFile(FILE_NAME, "rw")) {
                var appendIndex = (outputFile.length() > 0 ? outputFile.readLong() : 0L);
                index = appendIndex;
                outputFile.seek(0);
                outputFile.writeLong(appendIndex + 1);
                outputFile.seek(appendIndex * PERSON_SIZE + 8);
                outputFile.writeBytes(person.getName());
                outputFile.writeBytes(person.getStreet());
                outputFile.writeBytes(person.getCity());
                outputFile.writeBytes(person.getState());
                outputFile.writeBytes(person.getZip());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        buttons.get(Buttons.FIRST).setOnAction(event -> {
            index = 0;
            Person person = readEntry(index);
            setTextFields(person);
        });
        buttons.get(Buttons.NEXT).setOnAction(event -> {
            if (index < 0) {
                index = 0;
            } else {
                index++;
            }
            Person person = readEntry(index);
            setTextFields(person);
        });
        buttons.get(Buttons.PREV).setOnAction(event -> {
            if (index <= 0) {
                index = 0;
            } else {
                index--;
            }
            Person person = readEntry(index);
            setTextFields(person);
        });
        buttons.get(Buttons.LAST).setOnAction(event -> {
            index = getAppendIndex() - 1;
            Person person = readEntry(index);
            setTextFields(person);
        });
        //todo button update
        buttons.get(Buttons.UPDATE).setOnAction(event -> {
            var person = new Person(textFields.get(Fields.NAME).getText(),
                                    textFields.get(Fields.STREET).getText(),
                                    textFields.get(Fields.CITY).getText(),
                                    textFields.get(Fields.STATE).getText(),
                                    textFields.get(Fields.ZIP).getText());
            updateEntry(person, index);
        });

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
        hBoxes[3].getChildren()
                 .addAll(buttons.get(Buttons.ADD),
                         buttons.get(Buttons.FIRST),
                         buttons.get(Buttons.NEXT),
                         buttons.get(Buttons.PREV),
                         buttons.get(Buttons.LAST),
                         buttons.get(Buttons.UPDATE));
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

    private long getAppendIndex() {
        var appendIndex = 0L;
        try (var inputFile = new RandomAccessFile(FILE_NAME, "r")) {
            inputFile.seek(0);
            appendIndex = inputFile.readLong();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return appendIndex;
    }

    private void updateEntry(Person person, long index) {
        try (var outputFile = new RandomAccessFile(FILE_NAME, "rw")) {
            outputFile.seek(index * PERSON_SIZE + 8);
            outputFile.writeBytes(person.getName());
            outputFile.writeBytes(person.getStreet());
            outputFile.writeBytes(person.getCity());
            outputFile.writeBytes(person.getState());
            outputFile.writeBytes(person.getZip());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setTextFields(Person person) {
        if (person == null) {
            return;
        }
        textFields.get(Fields.NAME).setText(person.getName());
        textFields.get(Fields.STREET).setText(person.getStreet());
        textFields.get(Fields.CITY).setText(person.getCity());
        textFields.get(Fields.STATE).setText(person.getState());
        textFields.get(Fields.ZIP).setText(person.getZip());
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

    private Person readEntry(long index) {
        Person person = null;
        try (var inputFile = new RandomAccessFile(FILE_NAME, "r")) {
            inputFile.seek(0);
            long maxIndex = inputFile.readLong() - 1;
            if (maxIndex < index) {
                throw new IllegalArgumentException("Index is too big");
            }
            inputFile.seek(index * PERSON_SIZE + 8);
            byte[] name = new byte[32];
            byte[] street = new byte[32];
            byte[] city = new byte[20];
            byte[] state = new byte[2];
            byte[] zip = new byte[5];
            inputFile.read(name);
            inputFile.read(street);
            inputFile.read(city);
            inputFile.read(state);
            inputFile.read(zip);
            person = new Person(new String(name),
                                new String(street),
                                new String(city),
                                new String(state),
                                new String(zip));
        } catch (IllegalArgumentException | IOException e) {
            e.printStackTrace();
        }
        return person;
    }

    //todo add function that fill fields from person class object
    public static void main(String[] args) {
        launch();
    }

}