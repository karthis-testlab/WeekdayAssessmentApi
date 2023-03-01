package com.ta.spring.weekday.assessment.WeekdayAssessmentApi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonPropertyOrder({
    "page",
    "per_page",
    "total",
    "total_pages",
    "data",
    "support"
})
public class UsersV3 {

    private int page;
    @JsonProperty("per_page")
    private int perPage;
    private int total;
    @JsonProperty("total_pages")
    private int totalPages;
    private List<DataKey> data;
    private Support support;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @JsonPropertyOrder({
        "id",
        "email",
        "first_name",
        "last_name",
        "avatar"
    })
    public static class DataKey {

        private int id;
        private String email;
        @JsonProperty("first_name")
        private String firstName; 
        @JsonProperty("last_name")
        private String lastName;
        private String avatar;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @JsonPropertyOrder({
        "url",
        "text"
    })
    public static class Support {

        private String url;
        private String text;

    }
    
}