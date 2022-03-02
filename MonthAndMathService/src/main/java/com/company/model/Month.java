package com.company.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Month {
    @NotEmpty(message = "You must supply a number.")
    @Size(min =1,max = 12,message = "Input out of range")
    private Integer number;
    @NotEmpty(message = "You must supply the month.")
    private String month;


    public Month() {
    }

    public Month(Integer number, String month) {
        this.number = number;
        this.month = month;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
