package com.journal.schedulecalendar.restapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class AutoAttendanceBody implements Serializable {

    @JsonProperty("eventId")
    private String eventId;

    @JsonProperty("personId")
    private String personId;

    @JsonProperty("attendanceFact")
    private String attendanceFact;

    @JsonCreator
    public AutoAttendanceBody(@JsonProperty("eventId") String eventId,
                              @JsonProperty("personId") String personId,
                              @JsonProperty("attendanceFact") String attendanceFact) {
        this.eventId = eventId;
        this.personId = personId;
        this.attendanceFact = attendanceFact;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getAttendanceFact() {
        return attendanceFact;
    }

    public void setAttendanceFact(String attendanceFact) {
        this.attendanceFact = attendanceFact;
    }

    @Override
    public String toString() {
        return "AutoAttendanceBody{" +
                "eventId='" + eventId + '\'' +
                ", personId='" + personId + '\'' +
                ", attendanceFact='" + attendanceFact + '\'' +
                '}';
    }
}
