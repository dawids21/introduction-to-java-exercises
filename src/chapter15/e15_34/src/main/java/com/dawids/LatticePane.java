package com.dawids;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class LatticePane extends Pane {

    private final double size;
    private final Point head = new Point();

    public LatticePane() {
        this(10.0);
    }

    public LatticePane(double size) {
        this.size = size;
        getChildren().add(drawLines());
        head.setX((int) (size / 2));
        head.setY((int) (size / 2));
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

    public void makeMove(Directions direction) {
        var move = new Line();
        move.setStrokeWidth(4);
        move.startXProperty().bind(widthProperty().divide(size).multiply(head.getX()));
        move.startYProperty().bind(heightProperty().divide(size).multiply(head.getY()));
        switch (direction) {
            case UP:
                head.setY(head.getY() - 1);
                break;
            case DOWN:
                head.setY(head.getY() + 1);
                break;
            case RIGHT:
                head.setX(head.getX() + 1);
                break;
            case LEFT:
                head.setX(head.getX() - 1);
                break;
        }
        move.endXProperty().bind(widthProperty().divide(size).multiply(head.getX()));
        move.endYProperty().bind(heightProperty().divide(size).multiply(head.getY()));
        getChildren().add(move);
    }

    public enum Directions {
        UP,
        DOWN,
        RIGHT,
        LEFT;
    }

}
