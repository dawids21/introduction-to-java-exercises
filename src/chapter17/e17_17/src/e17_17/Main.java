package e17_17;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try (var outputBit = new BitOutputStream(new File("Exercise17_17.dat"))){
            outputBit.writeBit("010000100100001001101");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}