package com.journal.schedulecalendar.adapters.database;

import com.journal.schedulecalendar.Entity.EventAttendanceFact;
import com.journal.schedulecalendar.Entity.EventAttendanceFactId;
import org.springframework.data.repository.CrudRepository;

public interface EventAttendanceFactRepository extends CrudRepository<EventAttendanceFact, EventAttendanceFactId> {

    Iterable<EventAttendanceFact> findAll();

    EventAttendanceFact findEventAttendanceFactByEventIdAndPersonId(String eventId, String personId);

}
