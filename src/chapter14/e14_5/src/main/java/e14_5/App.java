package e14_5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This app shows sentence in circle.
 * 
 * @author Dawid Stasiak
 * @version 1.0
 */
public class App extends Application {
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    private final String LINE = "WELCOME TO JAVA ";

    /**
     * Start javaFX application
     * 
     * @param args
     * @since 1.0
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * This method is called when the application should stop, and provides a
     * convenient place to prepare for application exit and destroy resources.
     *
     * <p>
     * The implementation of this method provided by the Application class does
     * nothing.
     * </p>
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     * 
     * @throws java.lang.Exception if something goes wrong
     */
    public void start(Stage primaryStage) throws Exception {

        Pane mainPane = paintCircle();
        Scene scene = new Scene(mainPane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Pane paintCircle() {
        Font font = Font.font("Times New Roman", WIDTH / 10);
        Text[] texts = new Text[LINE.length()];
        Pane mainPane = new Pane();
        for (int i = 0; i < LINE.length(); i++) {
            texts[i] = new Text(Character.toString(LINE.charAt(i)));
            texts[i].setFont(font);
            texts[i].setX(WIDTH * 0.5 + WIDTH * 0.4 * Math.cos(2.0 * Math.PI / LINE.length() * i));
            texts[i].setY(HEIGHT * 0.5 + HEIGHT * 0.4 * Math.sin(2.0 * Math.PI / LINE.length() * i));
            texts[i].setRotate(Math.toDegrees(Math.PI * 0.5 + 2 * Math.PI / LINE.length() * i));
            mainPane.getChildren().add(texts[i]);
        }
        return mainPane;
    }
}
