package chapter8.GameOfFour;

import java.util.Scanner;

public class GameOfFour {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] game = new int[6][7];
        int winner = 0;
        int turn = 1;
        while(winner == 0) {
            displayGame(game);
            makeTurn(game, turn, input);
            turn = (turn == 1 ? 2 : 1);
            winner = checkGameFinished(game);
        }
        displayGame(game);
        System.out.println("The " + (winner == 1 ? "yellow" : "red") + " player won");
    }

    public static void makeTurn(int[][] game, int turn, Scanner input) {
        System.out.print("Drop a " + (turn == 1 ? "yellow" : "red") + " disk at column (0–6): ");
        int column = input.nextInt();
        while (true) {
            if (column < 0 || column > 6) {
                System.out.println("This column is out of bound. Choose another one.");
            }
            else if (game[0][column] != 0) {
                System.out.println("This column is full. Choose another one.");
            }
            else {
                break;
            }
            System.out.print("Drop a " + (turn == 1 ? "yellow" : "red") + " disk at column (0–6): ");
            column = input.nextInt();
        }
        if (game[5][column] == 0) {
            game[5][column] = turn;
        }
        else {
            for (int i = 1; i < game.length; i++) {
                if (game[i][column] != 0) {
                    game[i-1][column] = turn;
                    break;
                }
            }
        }
    }

    public static int checkGameFinished(int[][] game) {
        int winner = 0;
        for (int cellY = 0; cellY < game.length; cellY++) {
            for (int cellX = 0; cellX < game[0].length; cellX++)
            {
                int thisCell = game[cellY][cellX];
                if (thisCell == 0) {
                    continue;
                }
                if (cellY < 3 && cellX < 4) {
                    winner = checkColumn(game, cellY, cellX, thisCell);
                    if (winner == 0) {
                        winner = checkRow(game, cellY, cellX, thisCell);
                    }
                    if (winner == 0) {
                        winner = checkDiagonal(game, cellY, cellX, thisCell);
                    }
                }
                else if (cellY < 3 && cellX == 4) {
                    winner = checkColumn(game, cellY, cellX, thisCell);
                    if (winner == 0) {
                        winner = checkRow(game, cellY, cellX, thisCell);
                    }
                    if (winner == 0) {
                        winner = checkDiagonal(game, cellY, cellX, thisCell);
                    }
                    if (winner == 0) {
                        winner = checkAntiDiagonal(game, cellY, cellX, thisCell);
                    }
                }
                else if (cellY < 3 && cellX > 4) {
                    winner = checkColumn(game, cellY, cellX, thisCell);
                    if (winner == 0) {
                        winner = checkAntiDiagonal(game, cellY, cellX, thisCell);
                    }
                }
                else if (cellY >= 3 && cellX < 4) {
                    winner = checkRow(game, cellY, cellX, thisCell);
                }
                else {
                    break;
                }
                if (winner != 0) {
                    break;
                }
            }
            if (winner != 0) {
                break;
            }
        }
        return winner;
    }

    public static int checkAntiDiagonal(int[][] game, int cellY, int cellX, int thisCell) {
        int winner = thisCell;
        for (int i = 1; i < 4; i++) {
            if (game[cellY + i][cellX - i] != thisCell) {
                winner = 0;
                break;
            }
        }
        return winner;
    }

    public static int checkDiagonal(int[][] game, int cellY, int cellX, int thisCell) {
        int winner = thisCell;
        for (int i = 1; i < 4; i++) {
            if (game[cellY + i][cellX + i] != thisCell) {
                winner = 0;
                break;
            }
        }
        return winner;
    }

    public static int checkRow(int[][] game, int cellY, int cellX, int thisCell) {
        int winner = thisCell;
        for (int i = 1; i < 4; i++) {
            if (game[cellY][cellX + i] != thisCell) {
                winner = 0;
                break;
            }
        }
        return winner;
    }

    public static int checkColumn(int[][] game, int cellY, int cellX, int thisCell) {
        int winner = thisCell;
        for (int i = 1; i < 4; i++) {
            if (game[cellY + i][cellX] != thisCell) {
                winner = 0;
                break;
            }
        }
        return winner;
    }

    public static void displayGame(int[][] game) {
        System.out.println();
        for (int i = 0; i < game.length; i++) {
            System.out.print("|");
            for (int j = 0; j < game[0].length; j++) {
                if (game[i][j] == 1) {
                    System.out.print("Y|");
                }
                else if (game[i][j] == 2) {
                    System.out.print("R|");
                }
                else {
                    System.out.print(" |");
                }
            }
            System.out.println();
        }
        System.out.println("———————————————");
    }
}