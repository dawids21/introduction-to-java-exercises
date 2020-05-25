package com.dawids;

public class RandomWalkControl {
    private final Point head = new Point();
    private final boolean[][] freeSpots;

    public RandomWalkControl() {
        this(10);
    }

    public RandomWalkControl(int size) {
        head.setX(size / 2);
        head.setY(size / 2);
        freeSpots = new boolean[size][size];
        freeSpots[size / 2][size / 2] = true;
    }

    public void makeMove(Directions direction) {
        switch (direction) {
            case UP:
                head.setY(head.getY() - 1);
                break;
            case DOWN:
                head.setY(head.getY() + 1);
                break;
            case RIGHT:
                head.setX(head.getX() + 1);
                break;
            case LEFT:
                head.setX(head.getX() - 1);
                break;
        }
        freeSpots[head.getX()][head.getY()] = true;
    }

    public enum Directions {
        UP,
        DOWN,
        RIGHT,
        LEFT;
    }
}
