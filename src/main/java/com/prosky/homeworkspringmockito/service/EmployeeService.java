package com.prosky.homeworkspringmockito.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class EmployeeService {

    private int counter = 0;
    public int number = 10;

    public Map<String, Employee> employeeMap() {
        return new HashMap<>(employeeData);
    }

    Map<String, Employee> employeeData = new HashMap<>
    (Map.of(
            "ИвановИванИванович",
            new Employee("Иванов", "Иван", "Иванович", 1, 11_000),
            "ПетровПетрПетрович",
            new Employee("Петров", "Петр", "Петрович", 2, 15000),
            "СидоровСидорСидорович",
            new Employee("Сидоров", "Сидор", "Сидорович", 3, 13000),
            "ВасильевВасилийИванович",
            new Employee("Васильев", "Василий", "Иванович", 4, 16000),
            "СоловьевСтепанВасильевич",
            new Employee("Соловьев", "Степан", "Васильевич", 2, 22000),
            "СтепановГригорийМихайлович",
            new Employee("Степанов", "Григорий", "Михайлович", 5, 17000)
    ));


    public Employee addEmployee(String surname, String name, String patronymic, int department, int salary) {

        var kay = surname + name + patronymic;
        var employee = new Employee(surname, name, patronymic, department, salary);
        if (counter >= number) {
            throw new EmployeeStoragelsFullException("Список переполнен");
        }
        if (employeeData.containsKey(kay)) {
            throw new EmployeeAlreadyAddedException(kay + " - такой сотрудник уже есть");

        }
        employeeData.put(employee.getFullName(), employee);
        counter++;
        System.out.println("Добавлен сотрудник - " + employee);
        return employee;
    }


    public Employee removeEmployee(String surname, String name, String patronymic) {
        var kay = surname + name + patronymic;
        var resultRemove = employeeData.remove(kay);
        if (resultRemove == null) {
            throw new EmployeeNotFoundException(kay + " - Сотрудник не найден");
        }
        System.out.println("Сотрудник удален - " + resultRemove);
        return resultRemove;
    }

    public Employee getEmployee(String surname, String name, String patronymic) {
        var kay = surname + name + patronymic;
        var resultGet = employeeData.get(kay);
        if (resultGet == null) {
            throw new EmployeeNotFoundException(kay + " - Сотрудник не найден");
        }
        System.out.println("Сотрудник найден -  " + resultGet);
        return resultGet;

    }

    public Object employeeData() {
        return null;
    }

    public <E> List employeeTest() {
        return null;
    }
}