package com.journal.periodplanning.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@EqualsAndHashCode(of = {"lessonId", "personId"})
@ToString
public class LessonParticipantId implements Serializable {
    protected String lessonId;
    protected String personId;
}
