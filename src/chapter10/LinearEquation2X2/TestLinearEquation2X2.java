package chapter10.LinearEquation2X2;

public class TestLinearEquation2X2 {
    public static void main(String[] args) {
        LinearEquation2X2 le = new LinearEquation2X2(2.1, 3.7, 6.0, 4.2, 7.4, -3.0);
        double[] result = le.solve();
        System.out.println("X: " + result[0]);
        System.out.println("Y: " + result[1]);
    }    
}