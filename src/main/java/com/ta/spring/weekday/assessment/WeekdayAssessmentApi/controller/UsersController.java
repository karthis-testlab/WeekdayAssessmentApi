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
import com.ta.spring.weekday.assessment.WeekdayAssessmentApi.error.handling.UserNotFoundException;
import com.ta.spring.weekday.assessment.WeekdayAssessmentApi.model.Users;
import com.ta.spring.weekday.assessment.WeekdayAssessmentApi.model.UsersV2;
import com.ta.spring.weekday.assessment.WeekdayAssessmentApi.model.UsersV3;
import com.ta.spring.weekday.assessment.WeekdayAssessmentApi.service.UsersService;

@RestController
public class UsersController {    

    @Autowired
    UsersService usersService;

    @Autowired
    MessageSource messageSource;

    @GetMapping(path = "/api/users", produces = {"application/vnd.users.api-v1+json"})
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping(path = "/api/users", headers = {"X-API-VERSION=1"})
    public List<Users> getAllUsersHeader() {
        return usersService.getAllUsers();
    }

    @GetMapping(path = "/api/users", produces = {"application/vnd.users.api-v2+json"})
    public List<UsersV2> getAllUsersV2() {
        return usersService.getAllUsersV2();
    }

    @GetMapping(path = "/api/users", headers = {"X-API-VERSION=2"})
    public List<UsersV2> getAllUsersV2Header() {
        return usersService.getAllUsersV2();
    }

    @GetMapping(path = "/api/users", headers = {"X-API-VERSION=3"})
    public ResponseEntity<UsersV3> getAllUsersV3Header() {
        return ResponseEntity.ok().body(usersService.getAllUsersV3());
    }

    @GetMapping(path = "/api/user/{id}")
    public ResponseEntity<Users> getUsers(@PathVariable int id) {
        Locale locale = LocaleContextHolder.getLocale();
        Users user = usersService.getIndividualUser(id);
        if(user == null) {
            String errorMessage = messageSource.getMessage("not.found.error.message", null, "Unable to found user", locale);
            throw new UserNotFoundException(errorMessage);
        }
        return ResponseEntity.ok().body(user);
    }

    @GetMapping(path = "/api/users")
    public List<Users> filterUser(@RequestParam(name = "id", required = false) Integer id,
                            @RequestParam(name = "name", required = false) String name) {
         return usersService.filterUser(id, name);
    }

    @PostMapping(path = "/api/add/user")
    public ResponseEntity<Users> addUsers(@RequestBody Users users) {
        Users newUser = usersService.addUsers(users);
        if(newUser == null) {
            return ResponseEntity.internalServerError().body(newUser);
        }
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                  .buildAndExpand(newUser.getId())
                  .toUri();
        return ResponseEntity.created(uri).body(newUser);
    }

    @PatchMapping(path = "/api/update/user/mobilenumber/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable int id, @RequestBody Users reqBody) {
        Users updateUser = usersService.updateUserMobileNumber(id, reqBody);
        if(updateUser == null) {
            return ResponseEntity.internalServerError().body(updateUser);
        }
        return ResponseEntity.ok().body(updateUser);
    }

}