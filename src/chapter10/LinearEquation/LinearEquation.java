package chapter10.LinearEquation;

import java.math.BigDecimal;

public class LinearEquation {
    private double a1;
    private double b1;
    private double c1;
    private double a2;
    private double b2;
    private double c2;

    public LinearEquation(double a1, double b1, double c1, double a2, double b2, double c2) {
        this.a1 = a1;
        this.b1 = b1;
        this.c1 = c1;
        this.a2 = a2;
        this.b2 = b2;
        this.c2 = c2;
    }

    public static boolean isSolvable(double a1, double b1, double a2, double b2) {
        BigDecimal a = new BigDecimal(a1 * b2);
        BigDecimal b = new BigDecimal(a2 * b1);
        return (a.subtract(b).compareTo(new BigDecimal(0)) == 0 ? false : true);
    }

    public static double[] solve(double a1, double b1, double c1, double a2, double b2, double c2) {
        double[] result = new double[2];
        if (isSolvable(a1, b1, a2, b2)) {
            result[0] = (b2 * c1 - b1 * c2) / (a1 * b2 - a2 * b1);
            result[1] = (a1 * c2 - a2 * c1) / (a1 * b2 - a2 * b1);
        }
        return result;
    }

    public static double solveForX(double a1, double b1, double c1, double a2, double b2, double c2) {
        double result = 0;
        if (isSolvable(a1, b1, a2, b2)) {
            result = (b2 * c1 - b1 * c2) / (a1 * b2 - a2 * b1);
        }
        return result;
    }

    public static double solveForY(double a1, double b1, double c1, double a2, double b2, double c2) {
        double result = 0;
        if (isSolvable(a1, b1, a2, b2)) {
            result = (a1 * c2 - a2 * c1) / (a1 * b2 - a2 * b1);
        }
        return result;
    }

    public boolean isSolvable() {
        return isSolvable(a1, b1, a2, b2);
    }

    public double[] solve() {
        return solve(a1, b1, c1, a2, b2, c2);
    }

    public double solveForX() {
        return solveForX(a1, b1, c1, a2, b2, c2);
    }

    public double solveForY() {
        return solveForY(a1, b1, c1, a2, b2, c2);
    }
}