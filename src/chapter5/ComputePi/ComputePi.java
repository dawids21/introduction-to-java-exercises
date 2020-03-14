package chapter5.ComputePi;

import java.util.Scanner;

public class ComputePi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter i: ");
        int maxNum = input.nextInt();
        input.close();
        double pi = 0;
        for (int i = maxNum; i > 0; i--) {
            pi += (Math.pow(-1, i + 1) / (2.0 * i - 1));
        }
        pi *= 4;
        System.out.println("PI: " + pi);
    }    
}