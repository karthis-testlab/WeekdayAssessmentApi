package com.ta.spring.weekday.assessment.WeekdayAssessmentApi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpolyeesV2 {

    private int empId;
    private Name empName;
    private String empRole;
    private Address empaddress;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Address {		
		private String street;
		private String city;
		private String country;
		private String postCode;		
	}

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Name {		
		private String firstName;
		private String lastName;		
	}
    
}
