package e17_8;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class App {

    public static final String FILE_NAME = "Exercise17_08.dat";

    public static void main(String[] args) {
        var file = new File(FILE_NAME);
        var isNewFile = !file.exists();
        try (var randomAccessFile = new RandomAccessFile(file, "rw")) {
            if (isNewFile) {
                System.out.println("Create new file");
                randomAccessFile.writeInt(0);
            } else {
                var count = randomAccessFile.readInt();
                count += 1;
                System.out.println("This file is being edited for the " + count + " time");
                randomAccessFile.seek(0);
                randomAccessFile.writeInt(count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
