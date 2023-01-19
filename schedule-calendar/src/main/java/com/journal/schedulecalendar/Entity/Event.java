package com.journal.schedulecalendar.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "EVENT")
@Data
public class Event {

    @Id
    @Column(name = "EVENT_ID", nullable = false)
    private String eventId;

    @Column(name = "LESSON_ID", nullable = false)
    private String lessonId;

    @Column(name = "START_AT", nullable = false)
    private Date startAt;
}
