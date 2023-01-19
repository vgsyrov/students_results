package com.journal.schedulecalendar.app;

import com.journal.schedulecalendar.Entity.Event;
import com.journal.schedulecalendar.adapters.database.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Iterable<Event> allEvents() {
        return eventRepository.findAll();
    }

    public Event findById(String id) {
        return eventRepository.findEventByEventId(id);
    }

    public Iterable<Event> findByLessonId(String lessonId) {
        return eventRepository.findEventByLessonId(lessonId);
    }
}
