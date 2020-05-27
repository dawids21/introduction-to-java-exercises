package e17_2;

import java.io.*;
import java.math.BigInteger;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        try (var outputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Exercise17_02.dat",
                                                                                                   true)));) {
            var rand = new Random();
            for (var i = 0; i < 100; i++) {
                outputStream.writeInt(rand.nextInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        var sum = new BigInteger(String.valueOf(0));
        try (var inputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("Exercise17_02.dat")))) {
            while (true) {
                sum = sum.add(BigInteger.valueOf(inputStream.readInt()));
            }
        } catch (EOFException e) {
            System.out.println("Sum is " + sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
