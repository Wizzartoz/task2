package com.solve.task1.service.parser;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;

public interface Parser {
    void parse(File file) throws IOException, XMLStreamException;
}
