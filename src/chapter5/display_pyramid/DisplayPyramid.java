package chapter5.display_pyramid;

import java.util.Scanner;

public class DisplayPyramid {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of lines: ");
        int numberOfLines = input.nextInt();
        input.close();
        for (int lineIndex = 1; lineIndex <= numberOfLines; lineIndex++) {
            String line = "";
            for (int numberIndex = numberOfLines; numberIndex > 0; numberIndex--) {
                if (numberIndex <= lineIndex) {
                    line += (numberIndex + "  ");
                }
                else {
                    line += "   ";
                }
            }
            for (int numberIndex = 2; numberIndex <= lineIndex; numberIndex++) {
                line += (numberIndex + "  ");
            }
            System.out.println(line);
        }
    }    
}