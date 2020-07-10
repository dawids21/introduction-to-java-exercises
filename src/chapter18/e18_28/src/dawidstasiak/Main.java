package dawidstasiak;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Wrong arguments");
            System.exit(1);
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("Directory does not exist");
            System.exit(2);
        }

        var stackOfFiles = new ArrayDeque<File>();
        var size = 0L;
        stackOfFiles.push(file);
        while (!stackOfFiles.isEmpty()) {
            var currentFile = stackOfFiles.pop();
            if (currentFile.isDirectory()) {
                for (File fileInDirectory : Objects.requireNonNull(currentFile.listFiles())) {
                    stackOfFiles.push(fileInDirectory);
                }
            } else {
                size += currentFile.length();
            }
        }
        System.out.println("Directory size: " + size);
    }
}
