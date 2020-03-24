package chapter11.LargestRowsAndColumns;

import java.util.ArrayList;
import java.util.Scanner;

public class LargestRowsAndColumns {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size n: ");
        int size = input.nextInt();
        input.close();
        int[][] matrix = createMatrix(size);
        showMatrix(matrix);
        ArrayList<Integer> mostRows = countMaxRows(matrix);
        ArrayList<Integer> mostColumns = countMaxColumns(matrix);
        System.out.println("The largest row index: " + mostRows.toString());
        System.out.println("The largest column index: " + mostColumns.toString());
    }

    private static ArrayList<Integer> countMaxColumns(int[][] matrix) {
        ArrayList<Integer> maxColumns = new ArrayList<>();
        int maxNumberOfOnes = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            int numOfOnes = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == 1) {
                    numOfOnes++;
                }
            }
            if (numOfOnes > maxNumberOfOnes) {
                maxNumberOfOnes = numOfOnes;
                maxColumns.clear();
            }
            if (numOfOnes == maxNumberOfOnes) {
                maxColumns.add(i);
            }
        }
        return maxColumns;
    }

    private static ArrayList<Integer> countMaxRows(int[][] matrix) {
        ArrayList<Integer> maxRows = new ArrayList<>();
        int maxNumberOfOnes = 0;
        for (int i = 0; i < matrix.length; i++) {
            int numOfOnes = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    numOfOnes++;
                }
            }
            if (numOfOnes > maxNumberOfOnes) {
                maxNumberOfOnes = numOfOnes;
                maxRows.clear();
            }
            if (numOfOnes == maxNumberOfOnes) {
                maxRows.add(i);
            }
        }
        return maxRows;
    }

    private static void showMatrix(int[][] matrix) {
        System.out.println("The random array is");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static int[][] createMatrix(int size) {

        int[][] matrix = new int[size][size];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (Math.random() > 0.5 ? 1 : 0);
            }
        }
        return matrix;
    }

}