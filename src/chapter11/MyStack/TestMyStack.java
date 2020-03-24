package chapter11.MyStack;

import java.util.Scanner;

public class TestMyStack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MyStack stack = new MyStack();
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter " + i + " string: ");
            stack.push(input.nextLine());
        }
        input.close();
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}