package com.journal.resultscontrolapigateway.domain;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@JsonClassDescription
public class Person {
    @JsonPropertyDescription(value = "ID person")
    @JsonProperty("personId")
    private String personId;

    @JsonPropertyDescription(value = "Full Name")
    @JsonProperty("fullName")
    private String fullName;

    @JsonCreator
    public Person(
            @JsonProperty("personId") String personId,
            @JsonProperty("fullName") String fullName) {
        this.personId = personId;
        this.fullName = fullName;
    }

    public Person() {
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
