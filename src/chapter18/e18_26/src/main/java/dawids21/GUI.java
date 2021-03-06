package dawids21;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GUI {

    private static final Color freeColor = Color.WHITE;
    private static final Color crossedColor = Color.RED;
    private static final Color occupiedColor = Color.BLUE;

    private final Stage primaryStage;

    public GUI() {
        primaryStage = null;
    }

    public GUI(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void init() {
        if (primaryStage == null) {
            throw new NullPointerException();
        }
        var findButton = new Button("Find path");
        var clearButton = new Button("Clear path");
        var hBoxButton = new HBox(findButton, clearButton);
        var grid = new Rectangle[Maze.NUM_OF_ROWS][Maze.NUM_OF_COLUMNS];
        var gridPane = new GridPane();
        var mainPane = new BorderPane();

        findButton.setOnAction(event -> {
            Solver.findPath(App.getMaze());
            drawMaze(grid, App.getMaze());
        });

        clearButton.setOnAction(event -> {
            App.getMaze().clearPath();
            drawMaze(grid, App.getMaze());
        });

        hBoxButton.setAlignment(Pos.CENTER);
        hBoxButton.setSpacing(5);

        gridPane.setAlignment(Pos.CENTER);
        for (var i = 0; i < Maze.NUM_OF_ROWS; i++) {
            for (var j = 0; j < Maze.NUM_OF_COLUMNS; j++) {
                grid[i][j] = new Rectangle();
                grid[i][j].heightProperty().bind(mainPane.heightProperty().divide(Maze.NUM_OF_ROWS).subtract(10));
                grid[i][j].widthProperty().bind(mainPane.widthProperty().divide(Maze.NUM_OF_COLUMNS).subtract(10));
                grid[i][j].setFill(Color.WHITE);
                grid[i][j].setStroke(Color.BLACK);
                int rectangleX = i;
                int rectangleY = j;
                grid[i][j].setOnMouseClicked(mouseEvent -> {
                    switch (mouseEvent.getButton()) {
                        case PRIMARY:
                            App.getMaze().setCellCrossed(new Point(rectangleX, rectangleY));
                            ((Rectangle) mouseEvent.getSource()).setFill(crossedColor);
                            break;
                        case SECONDARY:
                            App.getMaze().setCellFree(new Point(rectangleX, rectangleY));
                            ((Rectangle) mouseEvent.getSource()).setFill(freeColor);
                            break;
                    }
                });
                gridPane.add(grid[i][j], i, j);
            }
        }

        mainPane.setCenter(gridPane);
        mainPane.setBottom(hBoxButton);
        mainPane.setPadding(new Insets(5));

        var scene = new Scene(mainPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawMaze(Rectangle[][] gridPane, Maze mazeLayout) {
        for (var i = 0; i < Maze.NUM_OF_ROWS; i++) {
            for (var j = 0; j < Maze.NUM_OF_COLUMNS; j++) {
                var point = new Point(i, j);
                if (!mazeLayout.isCellCrossed(point)) {
                    if (mazeLayout.isCellFree(point)) {
                        gridPane[i][j].setFill(freeColor);
                    } else {
                        gridPane[i][j].setFill(occupiedColor);
                    }
                }
            }
        }
    }
}
