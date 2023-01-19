package com.journal.academicperformance.adapters.eventlistener;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.io.Serializable;

@Data
public class EventAttendanceFactMessage implements Serializable {

    @JsonProperty("lessonId")
    private String lessonId;

    @JsonProperty("personId")
    private String personId;

    @JsonProperty("attendanceFact")
    private String attendanceFact;
}
