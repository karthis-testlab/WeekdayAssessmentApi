package com.ta.spring.weekday.assessment.WeekdayAssessmentApi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ta.spring.weekday.assessment.WeekdayAssessmentApi.model.Users;
import com.ta.spring.weekday.assessment.WeekdayAssessmentApi.model.UsersV2;
import com.ta.spring.weekday.assessment.WeekdayAssessmentApi.model.UsersV2.Name;

@Service
public class UsersService {
    
    public static List<Users> users = new ArrayList<Users>();
    public static List<UsersV2> usersV2 = new ArrayList<UsersV2>();
    private static int id = 0;

    static {
        users.add(Users.builder().id(++id).email("michael.lawson@reqres.in").name("Michael Lawson").mobileNumber("9876543210").build());
        users.add(Users.builder().id(++id).email("lindsay.ferguson@reqres.in").name("Lindsay Ferguson").mobileNumber("9876543211").build());
        users.add(Users.builder().id(++id).email("tobias.funke@reqres.in").name("Tobias Funke").mobileNumber("9876543212").build());
        users.add(Users.builder().id(++id).email("byron.fields@reqres.in").name("Byron Fields").mobileNumber("9876543213").build());
        users.add(Users.builder().id(++id).email("michael.lawson2@reqres.in").name("Michael Lawson").mobileNumber("9876543210").build());
    }

    public List<Users> getAllUsers() {
        return users;
    }

    public List<UsersV2> getAllUsersV2() {
        Name name = UsersV2.Name.builder().firstName("Karthikeyan").lastName("Rajendran").build();
        usersV2.add(UsersV2.builder().id(++id).email("karhikeyan.rajendran@reqres.in").fullName(name).mobileNumber("9876543214").build());
        return usersV2;
    }

    public List<Users> filterUser(Integer id, String name) {
        List<Users> filteredUser = null;

        if(id != null) {
            filteredUser = users.stream().filter(user -> user.getId() == id).collect(Collectors.toList());
        }

        if(name != null) {
            filteredUser = users.stream().filter(user -> user.getName().equals(name)).collect(Collectors.toList());
        }

        return filteredUser;
    }

}