package com.ta.spring.weekday.assessment.WeekdayAssessmentApi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    @GetMapping(path = "/api/welcome")
    public String getWelcomeMessage() {
        return "Hi! Amigos, Welcome to Test Architect Spring Boot Weekday Assessment";
    }
    


}
