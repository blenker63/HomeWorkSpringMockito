package com.prosky.homeworkspringmockito.controller;

import com.prosky.homeworkspringmockito.service.DepartmentService;
import com.prosky.homeworkspringmockito.service.Employee;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/{ID}/employee")
    public String employeePrint(@PathVariable Integer department) {
        if (department == null) {
            return departmentService.employeePrintAll().toString();
        } else {
            return departmentService.employeePrintDepartment(department).toString();
        }
    }

    @GetMapping("{ID}//sum")
    public String employeeSumSalary(@PathVariable Integer department) {
        return "Сумма зарплат департамента - " + department + ": " + String.valueOf(departmentService.employeeSumSalary(department)) + "рублей";
    }

    @GetMapping(path = "{ID}//min-salary")
    public String employeeMinSalary(@PathVariable Integer department) {
        return "Сотрудник департамента - " + department + " с минимальной зарплатой - " + String.valueOf(departmentService.employeeMinSalary(department));
    }

    @GetMapping(path = "{ID}//max-salary")
    public String employeeMaxSalary(@PathVariable Integer department) {
        if (department == null)
            throw new RuntimeException("Данные введены не полностью");
        else
            return "Сотрудник департамента - " + department + " с максимальной зарплатой - " + String.valueOf(departmentService.employeeMaxSalary(department));
    }

    @GetMapping( path = "/employee/1")
    public Map<Integer, List<Employee>> allEmployeeDepartment() {
        return departmentService.allEmployeeDepartment();
   }
}
