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
            var line = new Line();
            line.startYProperty().bind(heightProperty().divide(size).multiply(i));
            line.endXProperty().bind(widthProperty());
            line.endYProperty().bind(line.startYProperty());
            line.setStroke(Color.GRAY);
            grid.getChildren().add(line);
        }
        return grid;
    }
}
