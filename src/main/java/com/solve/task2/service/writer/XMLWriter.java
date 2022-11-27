package com.solve.task2.service.writer;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.solve.task2.model.XMLObj;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class XMLWriter implements FileWriter<XMLObj> {
    @Override
    public void write(List<XMLObj> objs, String filename) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.writeValue(new File(filename), objs);
    }
}
