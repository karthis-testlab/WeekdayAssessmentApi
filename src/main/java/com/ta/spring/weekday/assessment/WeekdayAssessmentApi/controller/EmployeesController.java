package com.ta.spring.weekday.assessment.WeekdayAssessmentApi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ta.spring.weekday.assessment.WeekdayAssessmentApi.model.Empolyees;
import com.ta.spring.weekday.assessment.WeekdayAssessmentApi.service.EmployeeService;

@RestController
public class EmployeesController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(path = "/api/employees")
    public List<Empolyees> getEmployees() {       
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/api/employee")
    public List<Empolyees> getEmployees(@RequestParam(name = "id", required = false) Integer id,
                                        @RequestParam(name = "name", required = false) String name,
                                        @RequestParam(name = "role", required = false) String role) {       
        return employeeService.getEmployee(id, name, role);
    }

}
