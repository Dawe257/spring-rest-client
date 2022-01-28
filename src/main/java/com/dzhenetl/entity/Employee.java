package com.dzhenetl.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Employee {

    private Integer id;
    private String name;
    private String surname;
    private String department;
    private Integer salary;

    public Employee() {}

    public Employee(String name, String surname, String department, Integer salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }
}
