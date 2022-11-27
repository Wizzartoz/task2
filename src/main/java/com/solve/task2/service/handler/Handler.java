package com.solve.task2.service.handler;

import com.solve.task2.model.Driver;
import com.solve.task2.model.XMLObj;

import java.util.List;

public interface Handler {
    List<XMLObj> handle(List<Driver> drivers);
}
