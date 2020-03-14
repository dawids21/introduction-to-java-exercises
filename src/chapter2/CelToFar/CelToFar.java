package chapter2.CelToFar;

import java.util.Scanner;

public class CelToFar {
    public static void main(final String[] args) {
        final Scanner input = new Scanner(System.in);
        System.out.print("Write temperature in celsius: ");
        final double celsius = input.nextDouble();
        final double fahrenheit = (9.0 / 5.0) * celsius + 32;
        System.out.println("Celsius: " + celsius + "\n"
                            + "Fahrenheit: " + fahrenheit);
        input.close();
    }    
}