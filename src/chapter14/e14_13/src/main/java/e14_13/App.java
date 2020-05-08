package e14_13;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        PieChart pieChart = new PieChart();
        for (int i = 0; i < THINGS.length; i++) {
            pieChart.getData().add(new Data(THINGS[i], PERCENT[i]));
        }
        vbox.getChildren().add(pieChart);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
