package com.prosky.homeworkspringmockito.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Optional<Employee> employeeMaxSalary(int department) {
        return employeeService.employeeData.values().stream()
                .filter(employeeData -> employeeData.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary));
    }

    public Optional<Employee> employeeMinSalary(int department) {
        return employeeService.employeeData.values().stream()
                .filter(employeeData -> employeeData.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary));
    }

    public List<Employee> employeePrintAll() {
        return employeeService.employeeData.values().stream()
                .sorted(Comparator.comparing(Employee::getDepartment))
                .collect(Collectors.toList());
    }

    public List<Employee> employeePrintDepartment(int department) {
        return employeeService.employeeData.values().stream()
                .filter(employeeData -> employeeData.getDepartment() == department)
                .collect(Collectors.toList());
    }

    public int employeeSumSalary(int department) {
        return employeeService.employeeData.values().stream()
                .filter(employeeData -> employeeData.getDepartment() == department)
                .mapToInt(employeeData -> employeeData.getSalary())
                .sum();
    }

    public Map<Integer, List<Employee>> allEmployeeDepartment() {
         return employeeService.employeeMap().values().stream()
                 .collect(Collectors.groupingBy(Employee :: getDepartment));
//                 .collect(Collectors.groupingBy(Employee :: getDepartment,
//                         Collectors.mapping(Employee :: getSurname, Collectors.toSet())));
        }
    }









