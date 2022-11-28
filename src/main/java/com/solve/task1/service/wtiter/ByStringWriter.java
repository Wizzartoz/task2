package com.solve.task1.service.wtiter;

import java.io.IOException;

public interface ByStringWriter {
    void open() throws IOException;
    void close();
    void write(String entity) throws IOException;
}
