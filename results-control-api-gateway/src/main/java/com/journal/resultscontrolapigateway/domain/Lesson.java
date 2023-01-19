package com.journal.resultscontrolapigateway.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Lesson {
    @JsonProperty("lessonId")
    private String lessonId;

    @JsonProperty("lessonName")
    private String lessonName;

    // TODO проверить надо ли это убирать
//    @JsonCreator
//    public Lesson(
//            @JsonProperty("lessonId") String lessonId,
//            @JsonProperty("lessonName") String lessonName) {
//        this.lessonId = lessonId;
//        this.lessonName = lessonName;
//    }

}
