package chapter6.PalindromeInteger;

import java.util.Scanner;

public class PalindromeInteger {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        input.close();
        System.out.println("The number " + number + " " + (isPalindrome(number) ? "is" : "is not") + " a palindrome");
    }   
    public static int reverse (int number){
        int reversedNumber = 0;
        while (number != 0) {
            reversedNumber = (reversedNumber * 10) + (number % 10);
            number /= 10;
        }
        return reversedNumber;
    }
    public static boolean isPalindrome(int number) {
        return (number == reverse(number));
    }
}