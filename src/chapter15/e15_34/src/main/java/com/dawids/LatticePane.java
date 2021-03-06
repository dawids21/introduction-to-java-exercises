package com.dawids;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class LatticePane extends Pane {

    private final double size;

    public LatticePane() {
        this(10);
    }

    public LatticePane(int size) {
        this.size = size;
        getChildren().add(drawLines());
    }

    private Group drawLines() {
        var grid = new Group();
        for (var i = 0; i <= size; i++) {
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

    public void drawMove(Point head, RandomWalkControl.Directions direction) {
        var move = new Line();
        move.setStrokeWidth(4);
        move.startXProperty().bind(widthProperty().divide(size).multiply(head.getX()));
        move.startYProperty().bind(heightProperty().divide(size).multiply(head.getY()));
        switch (direction) {
            case UP:
                move.endXProperty().bind(widthProperty().divide(size).multiply(head.getX()));
                move.endYProperty().bind(heightProperty().divide(size).multiply(head.getY() - 1));
                break;
            case DOWN:
                move.endXProperty().bind(widthProperty().divide(size).multiply(head.getX()));
                move.endYProperty().bind(heightProperty().divide(size).multiply(head.getY() + 1));
                break;
            case RIGHT:
                move.endXProperty().bind(widthProperty().divide(size).multiply(head.getX() + 1));
                move.endYProperty().bind(heightProperty().divide(size).multiply(head.getY()));
                break;
            case LEFT:
                move.endXProperty().bind(widthProperty().divide(size).multiply(head.getX() - 1));
                move.endYProperty().bind(heightProperty().divide(size).multiply(head.getY()));
                break;
        }
        getChildren().add(move);
    }

}
