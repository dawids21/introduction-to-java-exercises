package e17_17;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BitOutputStream {

    private FileOutputStream output;
    private byte writeByte = 0;
    private int byteSize = 0;

    public BitOutputStream(File output) throws IOException {
        this.output = new FileOutputStream(output);
    }

    public void writeBit(char bit) {

    }

    public void writeBit(String bit) {

    }

    public void close() throws IOException {
        if (output != null) {
            output.close();
            output = null;
        }
    }
}
