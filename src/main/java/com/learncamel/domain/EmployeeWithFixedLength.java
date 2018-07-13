package com.learncamel.domain;

import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.FixedLengthRecord;

import java.math.BigDecimal;
import java.time.LocalDate;

@FixedLengthRecord(ignoreTrailingChars = true)
public class EmployeeWithFixedLength {

    @DataField(pos = 1, length = 3)
    private String id;

    @DataField(pos = 2, length = 10,trim = true,align = "L")
    private String name;

    @DataField(pos = 3, length = 10,trim = true,align = "L")
    private String tag;

    @DataField(pos =4, length = 10, pattern = "MM/dd/yyyy")
    private LocalDate joiningDate;

    @DataField(pos = 5, delimiter = "^",trim = true,align = "L")
    private int age;

    @DataField(pos = 6, length = 10, precision = 2,trim = true,align = "L")
    private BigDecimal annualSalary;


    public EmployeeWithFixedLength() {
    }

    public EmployeeWithFixedLength(String id, String name, String tag, LocalDate localDate, int age, BigDecimal annualSalary) {
        this.id = id;
        this.name = name;
        this.tag = tag;
        this.joiningDate=localDate;
        this.age=age;
        this.annualSalary=annualSalary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }


    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(BigDecimal annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public String toString() {
        return "EmployeeWithFixedLength{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", tag='" + tag + '\'' +
                ", joiningDate=" + joiningDate +
                ", age=" + age +
                ", annualSalry=" + annualSalary +
                '}';
    }
}
