package chapter8.MultipleMatrices;

import java.util.Scanner;

public class MultipleMatrices {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first matrix (3x3): ");
        double[][] matrix1 = getMatrix(input);
        System.out.print("Enter second matrix (3x3): ");
        double[][] matrix2 = getMatrix(input);
        input.close();
        double[][] resultMatrix = multiplyMatrix(matrix1, matrix2);
        printResultMultiplication(matrix1, matrix2, resultMatrix);
    } 

    public static double[][] getMatrix(Scanner input) {
        double[][] matrix = new double[3][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = input.nextDouble();
            }
        }
        return matrix;
    }
    public static double[][] multiplyMatrix(double[][] matrix1, double[][] matrix2) {
        double[][] resultMatrix = new double[3][3];
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
                for (int k = 0; k < matrix1.length; k++) {
                    resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return resultMatrix;
    } 
    public static void printResultMultiplication(   double[][] matrix1,
                                                    double[][] matrix2,
                                                    double[][] resultMatrix) {
        System.out.println("The multiplication of the matrices is");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.print(i == 1 ? "* " : "  ");
            for (int j = 0; j < matrix1[0].length; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.print(i == 1 ? "= " : "  ");
            for (int j = 0; j < matrix1[0].length; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
    } 
}