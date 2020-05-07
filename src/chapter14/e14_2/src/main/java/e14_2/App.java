package e14_2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        Image circle = new Image("O.png", 0, 90, true, true);
        Image cross = new Image("X.png", 0, 90, true, true);
        GridPane pane = new GridPane();
        pane.add(new ImageView(circle), 0, 0);
        pane.add(new ImageView(circle), 2, 0);
        pane.add(new ImageView(cross), 1, 0);
        pane.add(new ImageView(cross), 0, 1);
        pane.add(new ImageView(cross), 2, 1);
        pane.add(new ImageView(cross), 0, 2);
        pane.setAlignment(Pos.CENTER);
        Scene scene = new Scene(pane, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
