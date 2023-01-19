package com.journal.resultscontrolapigateway.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LessonParticipant {
    @JsonProperty("lessonId")
    private String lessonId;

    @JsonProperty("personId")
    private String personId;

    private String lessonName;

    private String personName;

    // TODO можно ли это убирать
//    @JsonCreator
//    public LessonParticipant(
//            @JsonProperty("lessonId") String lessonId,
//            @JsonProperty("personId") String personId) {
//        this.lessonId = lessonId;
//        this.personId = personId;
//
//    }
}
