package chapter2.Gratuity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Gratuity {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the subtotal and a gratuity rate: ");
        double subtotal = input.nextDouble();
        double gratuityRate = input.nextDouble();
        double gratuity = subtotal * (gratuityRate/100.0);
        double total = subtotal + gratuity;
        System.out.println("The gratuity is $" + round(gratuity, 2) + " and total is $" + round(total, 2));
        input.close();
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
    
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_EVEN);
        return bd.doubleValue();
    }
}