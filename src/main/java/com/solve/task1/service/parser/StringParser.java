package com.solve.task1.service.parser;

import com.solve.task1.exception.GetAttributeException;
import com.solve.task2.exception.ParseException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.solve.task1.service.wtiter.ByStringWriter;

public class StringParser implements Parser {
    private static final String SEPARATOR = "/>";
    private static final String NAME_REGEX = " name\\s*=\\s*\"(\\S+)\"";
    private static final String SURNAME_REGEX = "surname\\s*=\\s*\"(.+?)\" *";
    private static final String STRING_FORMAT_REGEX = " name=\"%s %s\"";
    private static final String APPEND_FOR_LINE = "\n";
    private static final String REPLACEMENT = "";

    private final ByStringWriter byStringWriter;

    public StringParser(ByStringWriter byStringWriter) {
        this.byStringWriter = byStringWriter;
    }

    @Override
    public void parse(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder person = new StringBuilder();
            StringBuilder persons = new StringBuilder();
            String line = reader.readLine();
            byStringWriter.open();
            while (Objects.nonNull(line)) {
                person.append(line).append(APPEND_FOR_LINE);
                if (line.endsWith(SEPARATOR)) {
                    persons.append(handlerString(person.toString()));
                    clearStringBuilder(person);
                }
                line = reader.readLine();
            }
            persons.append(person);
            byStringWriter.write(persons.toString());
        } catch (IOException e) {
            throw new ParseException(e.getMessage());
        } finally {
            byStringWriter.close();
        }
    }

    private void clearStringBuilder(StringBuilder builder) {
        builder.delete(0, builder.length());
    }

    private String handlerString(String person) throws IOException {
        String name;
        String surname;
        try {
            name = getAttribute(person, NAME_REGEX);
            surname = getAttribute(person, SURNAME_REGEX);
        } catch (GetAttributeException e) {
            throw new IOException(e);
        }
        String result = String.format(STRING_FORMAT_REGEX, name, surname);
        return person.replaceAll(SURNAME_REGEX, REPLACEMENT)
                .replaceAll(NAME_REGEX, result);
    }

    private String getAttribute(String person, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(person);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new GetAttributeException();
    }
}
