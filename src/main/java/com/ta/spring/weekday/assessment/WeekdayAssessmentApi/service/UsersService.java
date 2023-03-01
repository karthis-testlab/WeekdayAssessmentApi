package com.ta.spring.weekday.assessment.WeekdayAssessmentApi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ta.spring.weekday.assessment.WeekdayAssessmentApi.model.Users;
import com.ta.spring.weekday.assessment.WeekdayAssessmentApi.model.UsersV2;
import com.ta.spring.weekday.assessment.WeekdayAssessmentApi.model.UsersV3;
import com.ta.spring.weekday.assessment.WeekdayAssessmentApi.model.UsersV2.Name;
import com.ta.spring.weekday.assessment.WeekdayAssessmentApi.model.UsersV3.DataKey;
import com.ta.spring.weekday.assessment.WeekdayAssessmentApi.model.UsersV3.Support;

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

    public UsersV3 getAllUsersV3() {

        List<DataKey> data = new ArrayList<DataKey>();
        data.add(UsersV3.DataKey.builder().id(++id).email("michael.lawson@reqres.in").firstName("Michael").lastName("Lawson").avatar("https://reqres.in/img/faces/7-image.jpg").build());
        data.add(UsersV3.DataKey.builder().id(++id).email("lindsay.ferguson@reqres.in").firstName("Lindsay").lastName("Ferguson").avatar("https://reqres.in/img/faces/8-image.jpg").build());
        
        Support support = new Support();
        support = UsersV3.Support.builder().url("https://reqres.in/#support-heading").text("To keep ReqRes free, contributions towards server costs are appreciated!").build();
        
        UsersV3 usersV3 = UsersV3.builder().page(2).perPage(6).total(12).totalPages(2).data(data).support(support).build();

        return usersV3;

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

    public Users addUsers(Users users) {
        Users newUser = Users.builder().id(++id).name(users.getName()).email(users.getEmail()).mobileNumber(users.getMobileNumber()).build();
        return newUser;
    }

    public Users updateUserMobileNumber(int id, Users reqBody) {
        Users updateUser = users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
        if(updateUser != null) {
            updateUser.setMobileNumber(reqBody.getMobileNumber());
        }
        return updateUser;
    }

    public Users getIndividualUser(int id) {
        Users user = users.stream().filter(usr -> usr.getId() == id).findFirst().orElse(null);
        return user;
    }

}