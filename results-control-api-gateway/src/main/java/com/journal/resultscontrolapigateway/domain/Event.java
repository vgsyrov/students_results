package com.journal.resultscontrolapigateway.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Event {

    @JsonProperty("eventId")
    private String eventId;

    @JsonProperty("lessonId")
    private String lessonId;

    @JsonProperty("startAt")
    private Date startAt;

    // TODO надо ли это убирать
//    @JsonCreator
//    public Event(
//            @JsonProperty("eventId") String eventId,
//            @JsonProperty("lessonId") String lessonId,
//            @JsonProperty("startAt") Date startAt
//    ) {
//        this.eventId = eventId;
//        this.lessonId = lessonId;
//        this.startAt = startAt;
//    }
}
