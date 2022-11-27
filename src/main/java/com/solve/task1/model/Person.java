package com.solve.task1.model;

public class Person {
    private String name;
    private String surname;
    private String birthDate;

    public Person() {
    }

    public Person(String name, String surname, String birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public String getName() {
        return String.format("%s %s", name, surname);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("<person name=\"%s %s\" birthDate=\"%s\"/>", name, surname, birthDate);
    }
}
