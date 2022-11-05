package com.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Variables {

    @NotNull(message = "Basic_salary can not be empty")
    private String basic_salary;
    @NotNull(message = "House Rent can not be empty")
    private String house_rent;
    @NotNull(message = "Medical Allowance can not be empty")
    private String medical;
    @NotNull(message = "Conveyance can not be empty")
    private String con;

    @NotNull(message = "Festivale Bonus can not be empty")
    private String festival;
    @NotNull(message = "Festivale Bonus can not be empty")
    private String investment;

    public String getBasic_salary() {
        return basic_salary;
    }

    public void setBasic_salary(String basic_salary) {
        this.basic_salary = basic_salary;
    }

    public String getMedical() {
        return medical;
    }

    public void setMedical(String medical) {
        this.medical = medical;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public String getFestival() {
        return festival;
    }

    public void setFestival(String festival) {
        this.festival = festival;
    }

    private char category;
    private char zone;

    public String getInvestment() {
        return investment;
    }

    public void setInvestment(String investment) {
        this.investment = investment;
    }

    public char getZone() {
        return zone;
    }

    public void setZone(char zone) {
        this.zone = zone;
    }

    public char getCategory() {
        return category;
    }

    public void setCategory(char category) {
        this.category = category;
    }

    public String getHouse_rent() {
        return house_rent;
    }

    public void setHouse_rent(String house_rent) {
        this.house_rent = house_rent;
    }
}
