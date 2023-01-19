package com.journal.academicperformance.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "RESULT")
@Data
public class Result implements Serializable {

    public Result() {}

    public Result(String lessonId, String personId, ResultType resultType) {
        this.lessonId = lessonId;
        this.personId = personId;
        this.resultType = resultType;
        resultId = UUID.randomUUID().toString();
        createdAt = new Date();
    }

    @Id
    @Column(name = "RESULT_ID", nullable = false)
    private String resultId;

    @Column(name = "LESSON_ID", nullable = false)
    private String lessonId;


    @Column(name = "PERSON_ID", nullable = false)
    private String personId;

    @Column(name = "VALUE")
    private String value;

    @Column(name = "CREATE_DATE", nullable = false)
    private Date createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "RESULT_TYPE", length = 20, nullable = false)
    private ResultType resultType;

}
