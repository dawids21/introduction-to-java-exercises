package chapter5.bitLevelOperations;

import java.util.Scanner;

public class bitLevelOperations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int i = input.nextInt();
        input.close();
        String bits = "";
        for (int index = 15; index >= 0; index--) {
            bits += (((i >> index & 1) == 1) ? 1 : 0);
        }
        System.out.println("The bits are " + bits);
    }
}