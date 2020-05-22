package com.dawids;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;
    private final Vertex pointA = new Vertex(Math.random() * WIDTH, Math.random() * HEIGHT, 10);
    private final Vertex pointB = new Vertex(Math.random() * WIDTH, Math.random() * HEIGHT, 10);
    private final Vertex pointC = new Vertex(Math.random() * WIDTH, Math.random() * HEIGHT, 10);

    @Override
    public void start(Stage stage) {
        var pane = new Pane();
        pointA.setOnMouseDragged(event -> {
            pointA.setCenterX(event.getX());
            pointA.setCenterY(event.getY());
            calculateAngles();
        });
        pointB.setOnMouseDragged(event -> {
            pointB.setCenterX(event.getX());
            pointB.setCenterY(event.getY());
            calculateAngles();
        });
        pointC.setOnMouseDragged(event -> {
            pointC.setCenterX(event.getX());
            pointC.setCenterY(event.getY());
            calculateAngles();
        });
        calculateAngles();

        var line1 = new Line();
        line1.startXProperty().bind(pointA.centerXProperty());
        line1.startYProperty().bind(pointA.centerYProperty());
        line1.endXProperty().bind(pointB.centerXProperty());
        line1.endYProperty().bind(pointB.centerYProperty());

        var line2 = new Line();
        line2.startXProperty().bind(pointB.centerXProperty());
        line2.startYProperty().bind(pointB.centerYProperty());
        line2.endXProperty().bind(pointC.centerXProperty());
        line2.endYProperty().bind(pointC.centerYProperty());

        var line3 = new Line();
        line3.startXProperty().bind(pointC.centerXProperty());
        line3.startYProperty().bind(pointC.centerYProperty());
        line3.endXProperty().bind(pointA.centerXProperty());
        line3.endYProperty().bind(pointA.centerYProperty());

        var textA = new Text();
        textA.textProperty().bind(Bindings.format("%.2f", pointA.angleProperty()));
        textA.xProperty().bind(pointA.centerXProperty().add(10));
        textA.yProperty().bind(pointA.centerYProperty().subtract(10));

        var textB = new Text();
        textB.textProperty().bind(Bindings.format("%.2f", pointB.angleProperty()));
        textB.xProperty().bind(pointB.centerXProperty().add(10));
        textB.yProperty().bind(pointB.centerYProperty().subtract(10));

        var textC = new Text();
        textC.textProperty().bind(Bindings.format("%.2f", pointC.angleProperty()));
        textC.xProperty().bind(pointC.centerXProperty().add(10));
        textC.yProperty().bind(pointC.centerYProperty().subtract(10));
        pane.getChildren().addAll(pointA, pointB, pointC, line1, line2, line3, textA, textB, textC);
        var scene = new Scene(pane, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.show();
    }

    private double calculateAngle(Vertex vertex, Vertex pointA, Vertex pointB) {
        double[] length = new double[3];
        length[0] = calculateLength(pointA, pointB);
        length[1] = calculateLength(vertex, pointA);
        length[2] = calculateLength(vertex, pointB);
        double angle = Math.acos((length[0] * length[0] - length[1] * length[1] - length[2] * length[2]) / (length[1] * length[2] * -2));
        return Math.toDegrees(angle);
    }

    public static void main(String[] args) {
        launch();
    }

    private double calculateLength(Vertex point1, Vertex point2) {
        return Math.sqrt(Math.pow(point2.getCenterX() - point1.getCenterX(), 2) + Math.pow(point2.getCenterY() - point1.getCenterY(), 2));
    }

    private void calculateAngles() {
        pointA.setAngle(calculateAngle(pointA, pointB, pointC));
        pointB.setAngle(calculateAngle(pointB, pointA, pointC));
        pointC.setAngle(calculateAngle(pointC, pointA, pointB));
    }

    static class Vertex extends Circle {
        private final SimpleDoubleProperty angle = new SimpleDoubleProperty();

        Vertex() {
            super();
        }

        Vertex(double centerX, double centerY, double radius) {
            super(centerX, centerY, radius);
        }

        double getAngle() {
            return angle.get();
        }

        void setAngle(double angle) {
            this.angle.set(angle);
        }

        SimpleDoubleProperty angleProperty() {
            return angle;
        }
    }

}