package com.ta.spring.weekday.assessment.WeekdayAssessmentApi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ta.spring.weekday.assessment.WeekdayAssessmentApi.model.Empolyees;

@Service
public class EmployeeService {

    public static List<Empolyees> empolyees = new ArrayList<Empolyees>();
    public static int id = 0;

    static {
        empolyees.add(Empolyees.builder().empId(++id).empName("Karthikeyan").empRole("Senior Test Automation Engineer").build());
        empolyees.add(Empolyees.builder().empId(++id).empName("Gaj").empRole("Senior QA Manager").build());
        empolyees.add(Empolyees.builder().empId(++id).empName("Sabitha").empRole("QA Lead").build());
        empolyees.add(Empolyees.builder().empId(++id).empName("Hare").empRole("Senior Test Automation Engineer").build());
    }

    public List<Empolyees> getAllEmployees() {
        return empolyees;
    }

    public List<Empolyees> getEmployee(Integer id, String name, String role) {

        List<Empolyees> filterEmployee = null;

        if(id != null) {
            filterEmployee = empolyees.stream().filter(emp -> emp.getEmpId() == id).collect(Collectors.toList());
        }

        if(name != null) {
            filterEmployee = empolyees.stream().filter(emp -> emp.getEmpName().equals(name)).collect(Collectors.toList());
        }

        if(role != null) {
            filterEmployee = empolyees.stream().filter(emp -> emp.getEmpRole().equals(role)).collect(Collectors.toList());
        }

        return filterEmployee;
    }



}
