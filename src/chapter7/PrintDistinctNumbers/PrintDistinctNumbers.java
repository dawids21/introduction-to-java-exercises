package chapter7.PrintDistinctNumbers;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDistinctNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Integer[] array = new Integer[10];
        int length = 0;
        int inputNumber;
        System.out.print("Enter ten numbers: ");
        for (int index = 0; index < 10; index++) {
            inputNumber = input.nextInt();
            if (!Arrays.asList(array).contains(inputNumber)) {
                array[length] = inputNumber;
                length++;
            }
        }
        input.close();
        System.out.println("The number of distinct number is " + length);
        System.out.print("The distinct numbers are: ");
        for (int index = 0; index < length; index++) {
            System.out.print(array[index] + " ");
        }
    }    
}