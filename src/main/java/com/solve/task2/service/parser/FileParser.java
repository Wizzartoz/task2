package com.solve.task2.service.parser;

import com.solve.task2.model.Driver;

import java.io.File;
import java.util.List;

public interface FileParser {
    List<Driver> parse(File[] files);
}
