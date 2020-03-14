package chapter7.BeanMachine;

import java.util.Scanner;

public class BeanMachine {
    public static int simulateFall(int numberOfSlots) {
        int position = 0;
        for (int i = 0; i < numberOfSlots - 1; i++) {
            if (Math.random() > 0.5) {
                position++;
            }
        }
        return position;
    }
    public static void printMachine(int[] machine, int numberOfBalls) {
        int maxNumber = machine[0];
        for (int i = 1; i < machine.length; i++) {
            if (machine[i] > maxNumber) {
                maxNumber = machine[i];
            }
        }
        for (int i = maxNumber; i > 0; i--) {
            for (int j = 0; j < machine.length; j++) {
                if (machine[j] == i) {
                    System.out.print("O");
                    machine[j]--;
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of balls to drop: ");
        int numberOfBalls = input.nextInt();
        System.out.print("Enter the number of slots in the bean machine: ");
        int numberOfSlots = input.nextInt();
        input.close();
        int[] machine = new int[numberOfSlots];

        for (int i = 0; i < numberOfBalls; i++) {
            machine[simulateFall(numberOfSlots)]++;
        }

        printMachine(machine, numberOfBalls);
    }    
}