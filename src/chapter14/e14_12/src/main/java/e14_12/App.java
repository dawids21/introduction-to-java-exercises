package e14_12;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class App extends Application {
    public static final String[] THINGS = { "Project", "Quiz", "Midterm", "Final" };
    public static final int[] PERCENT = { 20, 10, 30, 40 };
    public static final Color[] COLORS = { Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW };

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.BOTTOM_CENTER);
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.setFillHeight(false);
        for (int i = 0; i < PERCENT.length; i++) {
            hbox.getChildren().add(getBar(i));
        }
        Scene scene = new Scene(hbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox getBar(int i) {
        VBox vbox = new VBox(5);
        vbox.setAlignment(Pos.CENTER);
        vbox.setFillWidth(false);
        Label lab = new Label(THINGS[i] + " -- " + PERCENT[i] + "%");
        lab.setAlignment(Pos.CENTER);
        Rectangle rec = new Rectangle(100, PERCENT[i] / 100.0 * 500, COLORS[i]);
        vbox.getChildren().addAll(lab, rec);
        return vbox;
    }
}
