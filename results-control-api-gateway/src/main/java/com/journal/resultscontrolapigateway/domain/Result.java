package com.journal.resultscontrolapigateway.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Result {

    @ApiModelProperty(
            value = "ID урока",
            name = "ID урока",
            dataType = "String",
            example = "initialLesson_1")
    @JsonProperty("lessonId")
    private String lessonId;

    @JsonProperty("personId")
    private String personId;

    @JsonProperty("value")
    private String value;

    @JsonProperty("createdAt")
    private Date createdAt;

    @JsonProperty("resultType")
    private String resultType;

    private String lessonName;

    private String personName;

// TODO это точно можно убрать?
//    @JsonCreator
//    public Result(
//            @JsonProperty("lessonId") String lessonId,
//            @JsonProperty("personId") String personId,
//            @JsonProperty("value") String value,
//            @JsonProperty("createdAt") Date createdAt,
//            @JsonProperty("resultType") String resultType
//    ) {
//        this.personId = personId;
//        this.lessonId = lessonId;
//        this.value = value;
//        this.createdAt = createdAt;
//        this.resultType = resultType;
//    }


}
