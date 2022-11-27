package com.solve.task2.model;

import java.util.Objects;

public class XMLObj {
    private String fine;
    private Double amount;

    public XMLObj() {
    }

    public XMLObj(String fine, Double amount) {
        this.fine = fine;
        this.amount = amount;
    }

    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XMLObj xmlObj = (XMLObj) o;
        return Objects.equals(fine, xmlObj.fine) && Objects.equals(amount, xmlObj.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fine, amount);
    }

    @Override
    public String toString() {
        return "XMLObj{" +
                "fine='" + fine + '\'' +
                ", amount=" + amount +
                '}';
    }
}
