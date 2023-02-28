package com.ta.spring.weekday.assessment.WeekdayAssessmentApi.error.handling;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String errorMessage) {
        super(errorMessage);
    }
    
}