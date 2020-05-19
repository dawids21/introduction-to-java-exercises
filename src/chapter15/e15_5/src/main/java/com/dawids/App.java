package com.dawids;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;


/**
 * JavaFX App
 */
public class App extends Application {
    TextField fieldInvestAmount = new TextField();
    TextField fieldNumOfYears = new TextField();
    TextField fieldAnnInterestRate = new TextField();
    TextField fieldFutureVal = new TextField();

    @Override
    public void start(Stage stage) {
        var gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        createLabels(gridPane);

        fieldInvestAmount.setAlignment(Pos.CENTER_RIGHT);
        fieldNumOfYears.setAlignment(Pos.CENTER_RIGHT);
        fieldAnnInterestRate.setAlignment(Pos.CENTER_RIGHT);
        fieldFutureVal.setAlignment(Pos.CENTER_RIGHT);
        fieldFutureVal.setEditable(false);
        var converter = new StringConverter<Double>() {
            @Override
            public String toString(Double object) {
                return String.format("$%1$.2f", object);
            }

            @Override
            public Double fromString(String string) {
                return Double.parseDouble(string);
            }
        };
        fieldFutureVal.setTextFormatter(new TextFormatter<>(converter, 0.0));
        gridPane.add(fieldInvestAmount, 1, 0);
        gridPane.add(fieldNumOfYears, 1, 1);
        gridPane.add(fieldAnnInterestRate, 1, 2);
        gridPane.add(fieldFutureVal, 1, 3);

        Button buttonCalculate = new Button("Calculate");
        buttonCalculate.setOnAction(event -> calculateInterest());
        GridPane.setHalignment(buttonCalculate, HPos.RIGHT);
        gridPane.add(buttonCalculate, 1, 4);

        var scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }

    private void calculateInterest() {
        double investAmount = Double.parseDouble(fieldInvestAmount.getText());
        double numOfYears = Double.parseDouble(fieldNumOfYears.getText());
        double annualInterestRate = Double.parseDouble(fieldAnnInterestRate.getText());
        double futureValue = investAmount * Math.pow(1 + (annualInterestRate / 1200.0), numOfYears * 12);
        ((TextFormatter<Double>) fieldFutureVal.getTextFormatter()).setValue(futureValue);
    }

    private void createLabels(GridPane gridPane) {
        var labInvestAmount = new Label("Investment Amount:");
        labInvestAmount.setAlignment(Pos.CENTER);
        var labNumOfYears = new Label("Number of Years:");
        labNumOfYears.setAlignment(Pos.CENTER);
        var labAnnInterestRate = new Label("Annual Interest Rate:");
        labAnnInterestRate.setAlignment(Pos.CENTER);
        var labFutureVal = new Label("Future Value:");
        labFutureVal.setAlignment(Pos.CENTER);

        gridPane.add(labInvestAmount, 0, 0);
        gridPane.add(labNumOfYears, 0, 1);
        gridPane.add(labAnnInterestRate, 0, 2);
        gridPane.add(labFutureVal, 0, 3);
    }

    public static void main(String[] args) {
        launch();
    }

}