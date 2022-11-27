package com.solve.task1.service.wtiter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterImpl implements Writer {

    private final String path;

    public WriterImpl(String path) {
        this.path = path;
    }

    @Override
    public void write(String person) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path,true))) {
            writer.append(person).append("\n");
        }
    }
}
