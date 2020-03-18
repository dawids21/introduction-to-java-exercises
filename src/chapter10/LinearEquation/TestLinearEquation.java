package chapter10.LinearEquation;

public class TestLinearEquation {
    public static void main(String[] args) {
        LinearEquation le = new LinearEquation(2.1, 3.7, 6.0, 4.2, 7.4, -3.0);
        double[] result = le.solve();
        System.out.println("X: " + result[0]);
        System.out.println("Y: " + result[1]);
    }    
}