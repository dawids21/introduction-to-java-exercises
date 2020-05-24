package com.dawids;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;

public class BeanMachinePane extends Pane {
    private final int width;

    public BeanMachinePane() {
        this(500);
    }

    public BeanMachinePane(int width) {
        this.width = width;
        Polyline outerBorder = drawOuterBorder();
        Line[] lines = drawLines();
        Circle[] circles = drawCircle();
        getChildren().add(outerBorder);
        getChildren().addAll(lines);
        getChildren().addAll(circles);
    }

    private Circle[] drawCircle() {
        Circle[] circles = new Circle[28];
        int counter = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j <= i; j++) {
                circles[counter] = new Circle(width / 2.0 - i * 15 + j * 30, 95 + i * 30, 5);
                circles[counter].setFill(Color.MAROON);
                counter++;
            }
        }
        return circles;
    }

    private Line[] drawLines() {
        Line[] lines = new Line[7];
        double y1 = 340;
        double y2 = 280;
        for (int i = 0; i < 7; i++) {
            double x = width / 2.0 - 90 + i * 30;
            lines[i] = new Line(x, y1, x, y2);
        }
        return lines;
    }

    private Polyline drawOuterBorder() {
        double[] points = {width / 2.0 - 15,
                           50,
                           width / 2.0 - 15,
                           70,
                           width / 2.0 - 120,
                           280,
                           width / 2.0 - 120,
                           340,
                           width / 2.0 + 120,
                           340,
                           width / 2.0 + 120,
                           280,
                           width / 2.0 + 15,
                           70,
                           width / 2.0 + 15,
                           50};
        return new Polyline(points);
    }
}
