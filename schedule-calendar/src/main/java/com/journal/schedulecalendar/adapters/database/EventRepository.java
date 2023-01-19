package com.journal.schedulecalendar.adapters.database;

import com.journal.schedulecalendar.Entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, String> {

    Event findEventByEventId(String id);

    Iterable<Event> findEventByLessonId(String id);

    Iterable<Event> findAll();
}
