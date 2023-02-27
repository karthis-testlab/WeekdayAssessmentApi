package com.ta.spring.weekday.assessment.WeekdayAssessmentApi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersV2 {

    private int id;
    private String email;
    private Name fullName;
    private String mobileNumber;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Name {
        private String firstName;
        private String lastName;
    }
    
}
