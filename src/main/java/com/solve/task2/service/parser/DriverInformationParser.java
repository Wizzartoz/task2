package com.solve.task2.service.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solve.task2.exception.ParseException;
import com.solve.task2.model.Driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DriverInformationParser implements FileParser {

    private static final String SEPARATOR = "}";

    @Override
    public List<Driver> parse(File[] files) {
        List<Driver> drivers = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for (File file : files) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                StringBuilder obj = new StringBuilder();
                String line = reader.readLine();
                while (line != null) {
                    obj.append(line.trim());
                    if (line.endsWith(SEPARATOR)) {
                        drivers.add(mapJsonObjToDriver(mapper, obj.toString()));
                        obj.delete(0, obj.length());
                    }
                    line = reader.readLine();
                }
            } catch (IOException e) {
                throw new ParseException(e.getMessage());
            }
        }
        return drivers;
    }

    private Driver mapJsonObjToDriver(ObjectMapper mapper, String obj) throws JsonProcessingException {
        return mapper.readValue(obj, Driver.class);
    }
}
