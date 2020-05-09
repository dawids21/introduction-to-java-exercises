package e14_19;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 500;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane axisX = drawXAxis();
        Pane axisY = drawYAxis();
        Polyline sinFunc = drawSinFunc();
        Polyline cosFunc = drawCosFunc();
        Pane pane = new Pane();
        pane.getChildren().addAll(axisX, axisY, sinFunc, cosFunc);
        drawLabels(pane);
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawLabels(Pane pane) {
        Font font = Font.font("UbuntuMono Nerd Font", 20);
        for (int i = -6; i <= 6; i++) {
            Text label = new Text();
            if (i < 0) {
                label.setX(WIDTH / 2.0 + i * Math.PI * 20 - 15);
                label.setY(HEIGHT / 2.0 + 20);
                label.setText("" + i + "\u03c0");
            } else if (i == 0) {
                label.setX(WIDTH / 2.0 - 5);
                label.setY(HEIGHT / 2.0 + 20);
                label.setText("0");
            } else {
                label.setX(WIDTH / 2.0 + i * Math.PI * 20 - 10);
                label.setY(HEIGHT / 2.0 + 20);
                label.setText("" + i + "\u03c0");
            }
            label.setFont(font);
            pane.getChildren().add(label);
        }
    }

    private Polyline drawSinFunc() {
        Polyline sinFunc = new Polyline();
        final double step = 1;
        double x = 100;
        while (x < WIDTH - 100) {
            sinFunc.getPoints().add(x);
            sinFunc.getPoints().add(-Math.sin((x - WIDTH / 2.0) * 0.05) * 100 + HEIGHT / 2.0);
            x += step;
        }
        return sinFunc;
    }

    private Polyline drawCosFunc() {
        Polyline cosFunc = new Polyline();
        final double step = 1;
        double x = 100;
        while (x < WIDTH - 100) {
            cosFunc.getPoints().add(x);
            cosFunc.getPoints().add(-Math.cos((x - WIDTH / 2.0) * 0.05) * 100 + HEIGHT / 2.0);
            x += step;
        }
        return cosFunc;
    }

    private Pane drawXAxis() {
        Pane axisX = new Pane();
        Line x = new Line(50, HEIGHT / 2.0, WIDTH - 50, HEIGHT / 2.0);
        Line x1 = new Line(x.getEndX(), x.getEndY(), x.getEndX() - 30, x.getEndY() - 20);
        Line x2 = new Line(x.getEndX(), x.getEndY(), x.getEndX() - 30, x.getEndY() + 20);
        axisX.getChildren().addAll(x, x1, x2);
        return axisX;
    }

    private Pane drawYAxis() {
        Pane axisY = new Pane();
        Line y = new Line(WIDTH / 2.0, HEIGHT - 50, WIDTH / 2.0, 50);
        Line y1 = new Line(y.getEndX(), y.getEndY(), y.getEndX() - 20, y.getEndY() + 30);
        Line y2 = new Line(y.getEndX(), y.getEndY(), y.getEndX() + 20, y.getEndY() + 30);
        axisY.getChildren().addAll(y, y1, y2);
        return axisY;
    }
}
