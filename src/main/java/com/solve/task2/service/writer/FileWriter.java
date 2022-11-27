package com.solve.task2.service.writer;

import java.io.IOException;
import java.util.List;

public interface FileWriter<T> {
    void write(List<T> objs, String filename) throws IOException;
}
