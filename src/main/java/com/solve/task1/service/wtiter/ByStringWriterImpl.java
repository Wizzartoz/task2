package com.solve.task1.service.wtiter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ByStringWriterImpl implements ByStringWriter {

    BufferedWriter writer;

    private final String path;

    public ByStringWriterImpl(String path) {
        this.path = path;
    }

    @Override
    public void open() throws IOException {
        this.writer = new BufferedWriter(new FileWriter(path, true));
    }

    @Override
    public void write(String person) throws IOException {
        writer.append(person);
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
                //stream already closed
        }
    }
}
