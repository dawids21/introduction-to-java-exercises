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

    public void writeBit(char bit) throws IOException {
        if (bit != '1' && bit != '0') {
            throw new IllegalArgumentException("Bit must be 0 or 1");
        } else {
            writeByte &= (bit == '1' ? 1 : 0);
            writeByte <<= 1;
            byteSize++;
        }
        if (byteSize == 8) {
            output.write(writeByte);
            byteSize = 0;
            writeByte = 0;
        }
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
