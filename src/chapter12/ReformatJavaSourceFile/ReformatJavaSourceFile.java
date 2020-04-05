package chapter12.ReformatJavaSourceFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReformatJavaSourceFile {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            System.out.println("Usage: java ReformatJavaSourceFile.java filename");
            System.exit(1);
        }
        File inputFile = new File(args[0]);
        if (!inputFile.exists()) {
            System.out.println("File does not exist");
            System.exit(2);
        }
        File outputFile = new File("new_" + args[0]);
        if (outputFile.exists()) {
            System.out.println("File alreay existx");
            System.exit(3);
        }

        reformat(inputFile, outputFile);
        outputFile.renameTo(inputFile);
    }

    private static void reformat(File inputFile, File outputFile) throws FileNotFoundException {
        Pattern pattern = Pattern.compile("(?<white>\\s*)(?<bracket>\\{?)(?<line>.*)");
        Matcher matcher;
        String line;

        try (Scanner input = new Scanner(inputFile); PrintWriter output = new PrintWriter(outputFile)) {
            while (input.hasNextLine()) {
                line = input.nextLine();
                matcher = pattern.matcher(line);
                if (matcher.find()) {
                    if (matcher.group("bracket").length() == 1) {
                        output.print(" {");
                    } else {
                        output.println();
                    }
                    output.print(matcher.group("white"));
                    output.print(matcher.group("line"));
                }
            }
        }
    }
}