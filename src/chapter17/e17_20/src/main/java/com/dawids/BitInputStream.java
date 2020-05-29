package com.dawids;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BitInputStream extends FilterInputStream {

    public BitInputStream(InputStream in) {
        super(in);
    }

    public String readByte() throws IOException {
        var inputByte = read();
        if (inputByte == -1) {
            return "";
        }
        return String.format("%8s", Integer.toBinaryString(inputByte)).replace(" ", "0");
    }

}
