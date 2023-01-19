package com.journal.schedulecalendar.restapi;

import com.journal.schedulecalendar.Entity.Event;
import com.journal.schedulecalendar.app.EventService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/list")
    public Iterable<Event> getEventsList(){
        return eventService.allEvents();
    }

    @GetMapping("/findById/{eventId}")
    public Event getEventById(@PathVariable String eventId){
        return eventService.findById(eventId);
    }

    @GetMapping("/findByLessonId/{lessonId}")
    public Iterable<Event> getEventsByLessonId(@PathVariable String lessonId){
        return eventService.findByLessonId(lessonId);
    }
}
