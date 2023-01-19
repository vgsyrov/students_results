package com.journal.schedulecalendar.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@IdClass(EventAttendanceFactId.class)
@Table(name = "EVENT_ATTENDANCE_FACT")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventAttendanceFact {

    @Id
    @Column(name = "EVENT_ID", nullable = false)
    private String eventId;

    @Id
    @Column(name = "PERSON_ID", nullable = false)
    private String personId;

    @Id
    @Column(name = "ATTENDANCE_FACT")
    private String attendanceFact;
}
