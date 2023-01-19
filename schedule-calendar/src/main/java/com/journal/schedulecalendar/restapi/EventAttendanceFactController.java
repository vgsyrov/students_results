package com.journal.schedulecalendar.restapi;

import com.journal.schedulecalendar.Entity.EventAttendanceFact;
import com.journal.schedulecalendar.app.EventAttendanceFactService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class EventAttendanceFactController {

    private final EventAttendanceFactService eventAttendanceFactService;

    public EventAttendanceFactController(EventAttendanceFactService eventAttendanceFactService) {

        this.eventAttendanceFactService = eventAttendanceFactService;
    }

    @GetMapping("/all-event-attendances")
    public Iterable<EventAttendanceFact> getEventAttendanceFactList(){
        return eventAttendanceFactService.getAllEventAttendanceFacts();
    }


    @RequestMapping(method={RequestMethod.POST, RequestMethod.PUT},
        path="/auto-attendance",
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public void autoAttendance(@RequestBody AutoAttendanceBody body) {
        eventAttendanceFactService.autoAttendance(body.getPersonId(), body.getEventId(), body.getAttendanceFact());
    }
}
