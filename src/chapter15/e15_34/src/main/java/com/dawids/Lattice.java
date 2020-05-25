package com.dawids;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Lattice extends Pane {
    public Lattice() {
        this(10.0);
    }

    public Lattice(double size) {
        getChildren().add(drawLines(size));
    }

    private Group drawLines(double size) {
        var grid = new Group();
        for (var i = 0; i < size; i++) {
            var lineHorizontal = new Line();
            lineHorizontal.startYProperty().bind(heightProperty().divide(size).multiply(i));
            lineHorizontal.endXProperty().bind(widthProperty());
            lineHorizontal.endYProperty().bind(lineHorizontal.startYProperty());
            lineHorizontal.setStroke(Color.GRAY);
            grid.getChildren().add(lineHorizontal);

            var lineVertical = new Line();
            lineVertical.startXProperty().bind(widthProperty().divide(size).multiply(i));
            lineVertical.endXProperty().bind(lineVertical.startXProperty());
            lineVertical.endYProperty().bind(heightProperty());
            lineVertical.setStroke(Color.GRAY);
            grid.getChildren().add(lineVertical);
        }
        return grid;
    }
}
