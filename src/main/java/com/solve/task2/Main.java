package com.solve.task2;

import com.solve.task2.exception.ParseException;
import com.solve.task2.model.Driver;
import com.solve.task2.model.XMLObj;
import com.solve.task2.service.handler.DriverHandler;
import com.solve.task2.service.handler.Handler;
import com.solve.task2.service.parser.DriverInformationParser;
import com.solve.task2.service.parser.FileParser;
import com.solve.task2.service.writer.FileWriter;
import com.solve.task2.service.writer.XMLWriter;

import java.io.IOException;
import java.io.File;
import java.util.List;

public class Main {

    private static final String FOLDER_NAME = "files";
    private static final String FILE_OUTPUT_NAME = "fines.xml";

    public static void main(String[] args) {
        File folder = new File(FOLDER_NAME);
        File[] files = folder.listFiles();
        FileParser parser = new DriverInformationParser();
        List<Driver> drivers = null;
        try {
            drivers = parser.parse(files);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Handler handler = new DriverHandler();
        List<XMLObj> objs = handler.handle(drivers);
        FileWriter<XMLObj> writer = new XMLWriter();
        try {
            writer.write(objs, FILE_OUTPUT_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
