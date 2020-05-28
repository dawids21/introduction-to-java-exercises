package e17_5;


import java.io.*;
import java.util.Arrays;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        try (var outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Exercise17_05.dat")))) {
            outputStream.writeObject(new int[]{1, 2, 3, 4, 5});
            outputStream.writeObject(new Date());
            outputStream.writeDouble(5.5);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (var inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("Exercise17_05.dat")))) {
            System.out.println(Arrays.toString(((int[]) inputStream.readObject())));
            System.out.println(inputStream.readObject());
            System.out.println(inputStream.readDouble());
        } catch (EOFException e) {
            System.out.println("Reading complete");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
