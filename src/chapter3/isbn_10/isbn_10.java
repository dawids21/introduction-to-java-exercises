package chapter3.isbn_10;

import java.util.Scanner;

public class isbn_10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first 9 digits of an ISBN as integer: ");
        int isbn = input.nextInt();
        input.close();
        int tenth_digit = 0;
        System.out.format("The ISBN-10 number is %09d", isbn);
        for (int i = 9; i > 0; i--) {
            int current_digit = isbn % 10;
            tenth_digit += current_digit * i;
            isbn /= 10;
            if (isbn == 0) {
                break;
            }
        }
        tenth_digit %= 11;
        if (tenth_digit == 10) {
            System.out.println("X");
        }
        else {
            System.out.println(tenth_digit);
        }
    }
}