package com.prosky.homeworkspringmockito.service;

import java.util.Objects;

public class Employee {
    private String surname;
    private String name;
    private String patronymic;
    private String fullName;
    private int department;
    private int salary;


    private static int counter = 0;


    public Employee(String surname, String name, String patronymic, int department, int salary) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.department = department;
        this.salary = salary;
        this.fullName = getSurname() + getName() + getPatronymic();
    }

    public String getSurname() {
        return this.surname;
    }

    public String getName() {
        return this.name;
    }

    public String getPatronymic() {
        return this.patronymic;
    }

    public String getFullName() {
        return this.fullName;
    }

    public int getDepartment() {
        return this.department;
    }

    public int getSalary() {
        return this.salary;
    }
    public static int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "ФИО: '" + getSurname() + '\''
                + getName() + '\''
                + getPatronymic() + '\'' +
                ", отдел - " + getDepartment() +
                ", зарплата, рублей - " + getSalary() +
                ";";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && surname.equals(employee.surname) && name.equals(employee.name) && patronymic.equals(employee.patronymic) && fullName.equals(employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic, fullName, department, salary);
    }
}
