package chapter7.MergeTwoLists;

import java.util.Arrays;
import java.util.Scanner;

public class MergeTwoLists {
    public static int[] getArray(Scanner input) {
        int listLength = input.nextInt();
        int[] list = new int[listLength];
        for (int i = 0; i < listLength; i++) {
            list[i] = input.nextInt();
        }
        Arrays.sort(list);
        return list;
    }   
    public static void mergeLists(int[] list1, int[] list2) {
        int list1Index = 0;
        int list2Index = 0;
        System.out.print("The merged list is ");
        while (list1Index < list1.length && list2Index < list2.length) {
            if (list1[list1Index] <= list2[list2Index]) {
                System.out.print(list1[list1Index] + " ");
                list1Index++;
            }
            else {
                System.out.print(list2[list2Index] + " ");
                list2Index++;
            }
        }
        if (list1Index == list1.length) {
            for (int i = list2Index; i < list2.length; i++) {
                System.out.print(list2[i] + " ");
            }
        }
        else if (list2Index == list2.length) {
            for (int i = list1Index; i < list1.length; i++) {
                System.out.print(list1[i] + " ");
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter list1: ");
        int[] list1 = getArray(input);
        System.out.print("Enter list2: ");
        int[] list2 = getArray(input);
        input.close();
        mergeLists(list1, list2);
    }    
}