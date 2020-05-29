package com.dawids;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BitOutputStream extends FilterOutputStream {

    private boolean closed = false;
    private byte writeByte = 0;
    private int byteSize = 0;

    public BitOutputStream(OutputStream out) {
        super(out);
    }

    public void writeBit(char bit) throws IOException {
        if (bit != '1' && bit != '0') {
            throw new IllegalArgumentException("Bit must be 0 or 1");
        } else {
            writeByte <<= 1;
            writeByte |= (bit == '1' ? 1 : 0);
            byteSize++;
        }
        if (byteSize == 8) {
            write(writeByte);
            byteSize = 0;
            writeByte = 0;
        }
    }

    public void writeBit(String bit) throws IOException {
        for (var i = 0; i < bit.length(); i++) {
            writeBit(bit.charAt(i));
        }
    }

    @Override
    public void close() throws IOException {
        if (!closed) {
            writeByte <<= 8 - byteSize;
            write(writeByte);
            writeByte = 0;
            byteSize = 0;
            super.close();
            closed = true;
        }
    }
}
