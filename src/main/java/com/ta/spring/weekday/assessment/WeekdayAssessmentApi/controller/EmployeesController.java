package com.ta.spring.weekday.assessment.WeekdayAssessmentApi.controller;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ta.spring.weekday.assessment.WeekdayAssessmentApi.error.handling.EmployeeNotFoundException;
import com.ta.spring.weekday.assessment.WeekdayAssessmentApi.model.Empolyees;
import com.ta.spring.weekday.assessment.WeekdayAssessmentApi.model.EmpolyeesV2;
import com.ta.spring.weekday.assessment.WeekdayAssessmentApi.service.EmployeeService;

@RestController
public class EmployeesController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    MessageSource messageSource;

    @GetMapping(path = "/api/employees", produces = {"application/vnd.employees.api-v1+json"})
    public List<Empolyees> getEmployees() {       
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/api/employees", produces = {"application/vnd.employees.api-v2+json"})
    public List<EmpolyeesV2> getEmployeesV2() {       
        return employeeService.getAllEmployeesV2();
    }

    @GetMapping(path = "/api/employee/{id}")
    public Empolyees getEmployee(@PathVariable int id) {
        Locale locale = LocaleContextHolder.getLocale();
        Empolyees empolyees = employeeService.getEmployee(id);
        if(empolyees == null) {
            String errorMessage = messageSource.getMessage("user.not.found.error.message", null, "User wasn't found", locale);
            System.out.println(errorMessage);
            throw new EmployeeNotFoundException(errorMessage);
        }
        return employeeService.getEmployee(id);
    }

    @GetMapping(path = "/api/employee")
    public List<Empolyees> getEmployee(@RequestParam(name = "id", required = false) Integer id,
                                        @RequestParam(name = "name", required = false) String name,
                                        @RequestParam(name = "role", required = false) String role) {       
        return employeeService.getEmployee(id, name, role);
    }

    @PostMapping(path = "/api/add/employee")
    public ResponseEntity<Empolyees> addEmpolyee(@RequestBody Empolyees employees){
        Empolyees newEmpolyees = employeeService.addNewEmployee(employees);
        if (newEmpolyees == null) {
            return ResponseEntity.internalServerError().body(employees);
        }
        URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                 .buildAndExpand(newEmpolyees.getEmpId())
                .toUri();
        return ResponseEntity.created(uri).body(newEmpolyees);
    }

    @PatchMapping(path = "/api/update/employee/role/{id}")
    public Empolyees updateEmployee(@PathVariable int id, @RequestBody Empolyees reqBody) {
        return employeeService.updateEmployeeRole(id, reqBody);
    }

}