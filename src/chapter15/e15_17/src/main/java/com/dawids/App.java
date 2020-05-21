package com.dawids;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * JavaFX App
 */
public class App extends Application {

    private final Pane pane = new Pane();

    @Override
    public void start(Stage stage) {
        var rectangle = new Rectangle();
        final var minX = new SimpleDoubleProperty(Double.POSITIVE_INFINITY);
        final var minY = new SimpleDoubleProperty(Double.POSITIVE_INFINITY);
        final var maxX = new SimpleDoubleProperty(Double.NEGATIVE_INFINITY);
        final var maxY = new SimpleDoubleProperty(Double.NEGATIVE_INFINITY);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        rectangle.setVisible(false);
        rectangle.xProperty().bind(minX);
        rectangle.yProperty().bind(minY);
        rectangle.widthProperty().bind(maxX.subtract(minX));
        rectangle.heightProperty().bind(maxY.subtract(minY));
        pane.getChildren().add(rectangle);

        final var numOfCircles = new AtomicInteger(0);
        pane.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                var circle = new Circle(event.getX(), event.getY(), 10, Color.WHITE);
                circle.setStroke(Color.BLACK);
                circle.setOnMouseClicked(eventCircle -> {
                    if (eventCircle.getButton() == MouseButton.SECONDARY) {
                        pane.getChildren().removeIf(n -> n == circle);
                    }
                });
                pane.getChildren().add(circle);
                numOfCircles.getAndIncrement();
                minY.set(Math.min(minY.get(), circle.getCenterY() - circle.getRadius()));
                maxX.set(Math.max(maxX.get(), circle.getCenterX() + circle.getRadius()));
                maxY.set(Math.max(maxY.get(), circle.getCenterY() + circle.getRadius()));
                rectangle.setVisible(numOfCircles.get() != 0);
            }
            minX.set(findMinX());
            minY.set(findMinY());
            maxX.set(findMaxX());
            maxY.set(findMaxY());
        });
        var scene = new Scene(pane, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    private double findMaxY() {
        double max = Double.NEGATIVE_INFINITY;
        for (Node n : pane.getChildren()) {
            if (n instanceof Circle) {
                max = Math.max(max, ((Circle) n).getCenterY() + ((Circle) n).getRadius());
            }
        }
        return max;
    }

    private double findMaxX() {
        double max = Double.NEGATIVE_INFINITY;
        for (Node n : pane.getChildren()) {
            if (n instanceof Circle) {
                max = Math.max(max, ((Circle) n).getCenterX() + ((Circle) n).getRadius());
            }
        }
        return max;
    }

    private double findMinY() {
        double min = Double.POSITIVE_INFINITY;
        for (Node n : pane.getChildren()) {
            if (n instanceof Circle) {
                min = Math.min(min, ((Circle) n).getCenterY() - ((Circle) n).getRadius());
            }
        }
        return min;
    }

    private double findMinX() {
        double min = Double.POSITIVE_INFINITY;
        for (Node n : pane.getChildren()) {
            if (n instanceof Circle) {
                min = Math.min(min, ((Circle) n).getCenterX() - ((Circle) n).getRadius());
            }
        }
        return min;
    }

    public static void main(String[] args) {
        launch();
    }

}