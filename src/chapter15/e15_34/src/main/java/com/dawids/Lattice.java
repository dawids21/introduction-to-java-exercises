package com.dawids;

import javafx.scene.Group;
import javafx.scene.layout.Pane;

public class Lattice extends Pane {
    public Lattice() {
        this(10);
    }

    public Lattice(int size) {
        getChildren().add(drawLines(size));
    }

    private Group drawLines(int size) {
        var grid = new Group();
        return grid;
    }
}
