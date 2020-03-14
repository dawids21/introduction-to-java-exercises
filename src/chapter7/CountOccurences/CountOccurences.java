package chapter7.CountOccurences;

import java.util.HashMap;
import java.util.Scanner;

public class CountOccurences {
    public static void count(int[] list, int length) {
        HashMap<Integer, Integer> numberOfOccurences = new HashMap<Integer, Integer>();
        for (int index = 0; index < length; index++) {
            if (numberOfOccurences.containsKey(list[index])) {
                numberOfOccurences.put(list[index], numberOfOccurences.get(list[index]) + 1);
            }
            else {
                numberOfOccurences.put(list[index], 1);
            }
        }
        for (int number: numberOfOccurences.keySet()) {
            int occurences = numberOfOccurences.get(number);
            System.out.println(number + " occurs " + occurences + (occurences > 1 ? " times" : " time"));
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] list = new int[100];
        int inputNumber;
        int index = 0;
        System.out.print("Enter the integers between 1 and 100: ");
        while ((inputNumber = input.nextInt()) != 0) {
            list[index] = inputNumber;
            index++;
        }
        input.close();
        count(list, index);
    }
}