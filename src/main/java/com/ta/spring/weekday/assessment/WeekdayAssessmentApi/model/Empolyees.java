package com.ta.spring.weekday.assessment.WeekdayAssessmentApi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empolyees {

    private int empId;
    private String empName;
    private String empRole;

    
}
