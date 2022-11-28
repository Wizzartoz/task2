package com.solve.task1;

import com.solve.task1.service.parser.Parser;
import com.solve.task1.service.parser.StringParser;
import com.solve.task1.service.wtiter.ByStringWriter;
import com.solve.task1.service.wtiter.ByStringWriterImpl;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;

public class ReadWriteAndHandleXMLFacade {

    private static final String FILE_PATH = "persons.xml";
    private static final String OUTPUT_FILE_PATH = "persons-out.xml";

    public void begin() {
        File file = new File(FILE_PATH);
        ByStringWriter byStringWriter = new ByStringWriterImpl(OUTPUT_FILE_PATH);
        Parser parser = new StringParser(byStringWriter);
        try {
            parser.parse(file);
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
