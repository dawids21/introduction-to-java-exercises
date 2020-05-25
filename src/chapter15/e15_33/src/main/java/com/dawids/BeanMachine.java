package com.dawids;


public class BeanMachine {
    private static final int MAX_NUM_OF_BALLS_IN_ROW = 6;

    private final int[] numberOfBallsInRows = {0, 0, 0, 0, 0, 0, 0, 0};

    public BeanMachine() {
    }

    public int getNumOfBallsInRow(int row) {
        return numberOfBallsInRows[row];
    }

    public int[] simulateFall() {
        var positions = new int[8];
        do {
            positions[0] = 0;
            for (int i = 1; i < numberOfBallsInRows.length - 1; i++) {
                if (Math.random() > 0.5) {
                    positions[i] = positions[i - 1] + 1;
                } else {
                    positions[i] = positions[i - 1];
                }
            }
        } while (getNumOfBallsInRow(positions[7]) == MAX_NUM_OF_BALLS_IN_ROW);
        numberOfBallsInRows[positions[7]]++;
        return positions;
    }
}
