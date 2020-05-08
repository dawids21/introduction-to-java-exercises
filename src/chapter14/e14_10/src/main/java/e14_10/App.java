package e14_10;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = drawCylinder();
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Pane drawCylinder() {
        Pane pane = new Pane();
        Ellipse topEllipse = new Ellipse(250, 100, 100, 50);
        topEllipse.setFill(Color.WHITE);
        topEllipse.setStroke(Color.BLACK);
        Line l1 = new Line(150, 100, 150, 400);
        Line l2 = new Line(350, 100, 350, 400);
        Pane bottomElipse = drawBottomEllipse();
        pane.getChildren().addAll(topEllipse, l1, l2, bottomElipse);
        return pane;
    }

    private Pane drawBottomEllipse() {
        Pane pane = new Pane();
        Arc arc1 = new Arc(250, 400, 100, 50, 180, 180);
        arc1.setType(ArcType.OPEN);
        arc1.setFill(Color.WHITE);
        arc1.setStroke(Color.BLACK);
        Arc arc2 = new Arc(250, 400, 100, 50, 0, 180);
        arc2.setType(ArcType.OPEN);
        arc2.setFill(Color.WHITE);
        arc2.setStroke(Color.BLACK);
        arc2.getStrokeDashArray().addAll(6.0, 21.0);
        pane.getChildren().addAll(arc1, arc2);
        return pane;
    }
}
