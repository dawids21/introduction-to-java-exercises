package com.dawids;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class LatticePane extends Pane {

    private final double size;

    public LatticePane() {
        this(10.0);
    }

    public LatticePane(double size) {
        this.size = size;
        getChildren().add(drawLines());
    }

    private Group drawLines() {
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

    public void drawMove(int x1, int y1, int x2, int y2) {
        var move = new Line();
        move.setStrokeWidth(4);
        move.startXProperty().bind(widthProperty().divide(size).multiply(x1));
        move.startYProperty().bind(heightProperty().divide(size).multiply(y1));
        move.endXProperty().bind(widthProperty().divide(size).multiply(x2));
        move.endYProperty().bind(heightProperty().divide(size).multiply(y2));
        getChildren().add(move);
    }

}
