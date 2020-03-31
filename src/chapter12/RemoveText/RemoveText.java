package chapter12.RemoveText;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class RemoveText {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Usage: java RemoveText.java" + " string file");
            System.exit(1);
        }

        File inputFile = new File(args[1]);

        if (!inputFile.exists()) {
            System.out.println("File does not exist");
            System.exit(2);
        }

        File outputFile = new File("new_" + inputFile.getName());

        if (outputFile.exists()) {
            System.out.println("File already exists");
            System.exit(3);
        }

        try (Scanner input = new Scanner(inputFile); PrintWriter output = new PrintWriter(outputFile)) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String new_line = line.replaceAll(args[0], "");
                output.println(new_line);
            }
        }
    }
}