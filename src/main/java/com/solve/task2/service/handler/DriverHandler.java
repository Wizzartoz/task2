package com.solve.task2.service.handler;

import com.solve.task2.model.Driver;
import com.solve.task2.model.XMLObj;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DriverHandler implements Handler {

    @Override
    public List<XMLObj> handle(List<Driver> drivers) {
        Map<String, Double> result = drivers.stream()
                .collect(Collectors.groupingBy(Driver::getType, Collectors.summingDouble(Driver::getFineAmount)));
        return createXMLObjList(result);

    }

    private List<XMLObj> createXMLObjList(Map<String, Double> result) {
        return result.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(item -> new XMLObj(item.getKey(), item.getValue())).collect(Collectors.toList());
    }
}
