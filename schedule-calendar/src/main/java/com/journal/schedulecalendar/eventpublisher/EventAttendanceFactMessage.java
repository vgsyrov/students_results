package com.journal.schedulecalendar.eventpublisher;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Builder
public class EventAttendanceFactMessage implements Serializable {

    @JsonCreator
    public EventAttendanceFactMessage(String lessonId, String personId, String attendanceFact) {
        this.lessonId = lessonId;
        this.personId = personId;
        this.attendanceFact = attendanceFact;
    }

    @JsonProperty("lessonId")
    private String lessonId;

    @JsonProperty("personId")
    private String personId;

    @JsonProperty("attendanceFact")
    private String attendanceFact;
}
