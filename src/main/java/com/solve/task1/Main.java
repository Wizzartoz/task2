package com.solve.task1;

import com.solve.task1.service.parser.Parser;
import com.solve.task1.service.parser.RegexParser;
import com.solve.task1.service.wtiter.Writer;
import com.solve.task1.service.wtiter.WriterImpl;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;

public class Main {
    private static final String FILE_PATH = "persons.xml";
    private static final String OUTPUT_FILE_PATH = "persons-out.xml";

    public static void main(String[] args) {
        File file = new File(FILE_PATH);
        Writer writer = new WriterImpl(OUTPUT_FILE_PATH);
        Parser parser = new RegexParser(writer);
        try {
            parser.parse(file);
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
