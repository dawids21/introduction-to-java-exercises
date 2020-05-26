package com.dawids;

import java.util.ArrayList;
import java.util.Collections;

public class RandomWalkControl {
    private final Point head = new Point();
    private final boolean[][] occupiedPlaces;
    private final LatticePane latticePane;
    private final int size;

    public RandomWalkControl(LatticePane latticePane) {
        this(10, latticePane);
    }

    public RandomWalkControl(int size, LatticePane latticePane) {
        this.size = size;
        this.latticePane = latticePane;
        head.setX(size / 2);
        head.setY(size / 2);
        occupiedPlaces = new boolean[size + 1][size + 1];
        occupiedPlaces[size / 2][size / 2] = true;
    }

    public void moveHead(Directions direction) {
        latticePane.drawMove(head, direction);
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
        occupiedPlaces[head.getX()][head.getY()] = true;
    }

    public enum Directions {
        UP,
        DOWN,
        RIGHT,
        LEFT;
    }

    public void makeMove() throws NoMoreMoveException {
        var currentX = head.getX();
        var currentY = head.getY();
        var availableMoves = new ArrayList<Directions>();
        if (currentX + 1 > size || currentX - 1 < 0 || currentY + 1 > size || currentY - 1 < 0) {
            throw new NoMoreMoveException(head, true);
        }
        if (!occupiedPlaces[currentX + 1][currentY]) {
            availableMoves.add(Directions.RIGHT);
        }
        if (!occupiedPlaces[currentX - 1][currentY]) {
            availableMoves.add(Directions.LEFT);
        }
        if (!occupiedPlaces[currentX][currentY + 1]) {
            availableMoves.add(Directions.DOWN);
        }
        if (!occupiedPlaces[currentX][currentY - 1]) {
            availableMoves.add(Directions.UP);
        }
        if (availableMoves.size() == 0) {
            throw new NoMoreMoveException(head, false);
        }
        Collections.shuffle(availableMoves);
        moveHead(availableMoves.get(0));
    }
}
