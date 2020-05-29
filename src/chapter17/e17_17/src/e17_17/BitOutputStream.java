package e17_17;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BitOutputStream {

    private final FileOutputStream output;

    public BitOutputStream(File output) throws IOException {
        this.output = new FileOutputStream(output);
    }

    public void writeBit(char bit) {

    }

    public void writeBit(String bit) {

    }

    public void close() {

    }
}
