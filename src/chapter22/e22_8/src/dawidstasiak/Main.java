package dawidstasiak;

import java.io.*;

public class Main {

    private static final String FILE_NAME = "prime_numbers.dat";
    private static final int LONG_SIZE_IN_BYTES = Long.SIZE / 8;

    public static void main(String[] args) throws IOException {
        var file = new File(FILE_NAME);
        if (!file.exists()) {
            if (!file.createNewFile()) {
                System.out.println("Cant open and/or create file");
                System.exit(1);
            }
        }

        long currentNumber;
        long counter;
        if (file.length() > 0) {
            try (var raFile = new RandomAccessFile(file, "r")) {
                raFile.seek(0);
                counter = raFile.readLong();
                if (counter > 0) {
                    raFile.seek(LONG_SIZE_IN_BYTES * counter);
                    currentNumber = raFile.readLong();
                } else {
                    currentNumber = 2;
                }
            }
        } else {
            try (var raFile = new RandomAccessFile(file, "rw")) {
                raFile.seek(0);
                raFile.writeLong(0L);
                counter = 0;
                currentNumber = 2;
            }
        }

        long squareRoot = 1;
        while (counter <= 1000) {
            int readNumbersFromFile = 0;
            boolean prime = true;
            while (readNumbersFromFile < counter) {
                var previousPrimeNumbers = new long[10000];
                int readNumbers = 0;
                try (var raFile = new RandomAccessFile(file, "r")) {
                    raFile.seek((readNumbersFromFile + 1) * LONG_SIZE_IN_BYTES);
                    for (int i = 0; i < 10000; i++) {
                        previousPrimeNumbers[i] = raFile.readLong();
                        readNumbersFromFile++;
                        readNumbers++;
                    }
                } catch (EOFException ignored) {

                }
                while (squareRoot * squareRoot < currentNumber) {
                    squareRoot++;
                }

                for (int i = 0; i < readNumbers && previousPrimeNumbers[i] <= squareRoot; i++) {
                    if (currentNumber % previousPrimeNumbers[i] == 0) {
                        prime = false;
                        break;
                    }
                }
                if (!prime) {
                    break;
                }

            }
            if (prime) {
                try (var raFile = new RandomAccessFile(file, "rw")) {
                    raFile.seek(0);
                    raFile.writeLong(counter + 1);
                    raFile.seek((counter + 1) * LONG_SIZE_IN_BYTES);
                    raFile.writeLong(currentNumber);
                }
                counter++;
            }
            currentNumber++;
        }

    }
}
