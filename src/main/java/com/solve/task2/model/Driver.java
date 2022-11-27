package com.solve.task2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Driver {
    @JsonProperty("date_time")
    private String dateTime;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("type")
    private String type;
    @JsonProperty("fine_amount")
    private double fineAmount;

    public Driver() {
    }

    public Driver(String dateTime, String firstName, String lastName, String type, double fineAmount) {
        this.dateTime = dateTime;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.fineAmount = fineAmount;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Double.compare(driver.fineAmount, fineAmount) == 0 && Objects.equals(dateTime, driver.dateTime) && Objects.equals(firstName, driver.firstName) && Objects.equals(lastName, driver.lastName) && Objects.equals(type, driver.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, firstName, lastName, type, fineAmount);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "dateTime='" + dateTime + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", type='" + type + '\'' +
                ", fineAmount=" + fineAmount +
                '}';
    }
}
