package com.solve.task1.service.parser;

import com.solve.task1.service.wtiter.Writer;
import com.solve.task1.model.Person;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.util.Objects;

public class RegexParser implements Parser {

    private static final String PREFIX = "person";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String BIRTH_DATE = "birthDate";
    private static final String BIRTH_DATA = "birthData";
    private static final String START_ELEMENT = "<persons>";
    private static final String END_ELEMENT = "</persons>";
    private final Writer writer;

    public RegexParser(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void parse(File file) throws IOException, XMLStreamException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileReader(file));
        while (reader.hasNext()) {
            XMLEvent nextEvent = reader.nextEvent();
            if (nextEvent.isStartDocument()) {
                writer.write(START_ELEMENT);
            }
            if (nextEvent.isEndDocument()) {
                writer.write(END_ELEMENT);
            }
            if (nextEvent.isStartElement()) {
                StartElement element = (StartElement) nextEvent;
                if (element.getName().toString().endsWith(PREFIX)) {
                    Person person = new Person();
                    person.setName(element.getAttributeByName(QName.valueOf(NAME)).getValue());
                    person.setSurname(element.getAttributeByName(QName.valueOf(SURNAME)).getValue());
                    Attribute attribute = element.getAttributeByName(QName.valueOf(BIRTH_DATE));
                    if (Objects.nonNull(attribute)) {
                        person.setBirthDate(attribute.getValue());
                    } else {
                        person.setBirthDate(element.getAttributeByName(QName.valueOf(BIRTH_DATA)).getValue());
                    }
                    writer.write(person.toString());
                }
            }
        }
    }
}
