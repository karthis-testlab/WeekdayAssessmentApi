package com.ta.spring.weekday.assessment.WeekdayAssessmentApi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {

    private int id;
    private String email;
    private String name;
    private String mobileNumber;
    
}
