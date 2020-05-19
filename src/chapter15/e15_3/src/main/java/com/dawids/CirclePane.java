package com.dawids;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CirclePane extends Pane {
    private final Circle circle = new Circle(40);
    private final double step = 30;

    public CirclePane() {
        super();
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        circle.setCenterX(circle.getRadius());
        circle.setCenterY(circle.getRadius());
        getChildren().add(circle);
    }

    public void moveCircleUp() {
        var actualY = circle.getCenterY();
        if (actualY >= circle.getRadius() + step) {
            circle.setCenterY(actualY - step);
        }
    }

    public void moveCircleDown() {
        var actualY = circle.getCenterY();
        var height = getHeight();
        if (actualY <= height - (circle.getRadius() + step)) {
            circle.setCenterY(actualY + step);
        }
    }

    public void moveCircleLeft() {
        var actualX = circle.getCenterX();
        if (actualX >= circle.getRadius() + step) {
            circle.setCenterX(actualX - step);
        }
    }

    public void moveCircleRight() {
        var actualX = circle.getCenterX();
        var width = getWidth();
        if (actualX <= width - (circle.getRadius() + step)) {
            circle.setCenterX(actualX + step);
        }
    }
}
