package chapter12.SumWithException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SumWithException {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean correctInput = false;
        int first = 0;
        int second = 0;
        do {
            System.out.print("Enter integer: ");
            try {
                first = input.nextInt();
                correctInput = true;
            } catch (InputMismatchException ex) {
                System.out.println("Not integer value, try again");
            } finally {
                input.nextLine();
            }
        } while (!correctInput);
        correctInput = false;
        do {
            System.out.print("Enter integer: ");
            try {
                second = input.nextInt();
                correctInput = true;
            } catch (InputMismatchException ex) {
                System.out.println("Not integer value, try again");
            } finally {
                input.nextLine();
            }
        } while (!correctInput);
        input.close();
        System.out.println("Sum is " + (first + second));
    }
}