package com.ta.spring.weekday.assessment.WeekdayAssessmentApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ta.spring.weekday.assessment.WeekdayAssessmentApi.model.Users;
import com.ta.spring.weekday.assessment.WeekdayAssessmentApi.model.UsersV2;
import com.ta.spring.weekday.assessment.WeekdayAssessmentApi.service.UsersService;

@RestController
public class UsersController {    

    @Autowired
    UsersService usersService;

    @GetMapping(path = "/api/users", produces = {"application/vnd.users.api-v1+json"})
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping(path = "/api/users", produces = {"application/vnd.users.api-v2+json"})
    public List<UsersV2> getAllUsersV2() {
        return usersService.getAllUsersV2();
    }

    @GetMapping(path = "/api/users")
    public List<Users> filterUser(@RequestParam(name = "id", required = false) Integer id,
                            @RequestParam(name = "name", required = false) String name) {
         return usersService.filterUser(id, name);
    }

}