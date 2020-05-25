package com.dawids;

public class RandomWalkControl {
    private final Point head = new Point();

    public RandomWalkControl() {
        this(10);
    }

    public RandomWalkControl(double size) {
        head.setX((int) (size / 2));
        head.setY((int) (size / 2));
    }
}
