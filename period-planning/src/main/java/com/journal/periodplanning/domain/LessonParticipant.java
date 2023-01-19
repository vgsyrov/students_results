package com.journal.periodplanning.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(LessonParticipantId.class)
@Table(name = "LESSON_PARTICIPANT")
@EqualsAndHashCode(of = "lessonId")
@ToString
public class LessonParticipant implements Serializable {

    public LessonParticipant(){}

    @Id
    @Column(name = "LESSON_ID", nullable = false)
    private String lessonId;

    @Id
    @Column(name = "PERSON_ID", nullable = false)
    private String personId;

}
