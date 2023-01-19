package com.journal.resultscontrolapigateway.adapters.restclients;

import com.journal.resultscontrolapigateway.domain.AutoAttendanceRequest;
import com.journal.resultscontrolapigateway.domain.EventAttendanceFact;
import com.journal.resultscontrolapigateway.domain.Event;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "${sc.service.name}", url = "${sc.service.url}")
@EnableAsync
public interface ScheduleCalendarClient {

    //EventController
    @GetMapping("/list")
    List<Event> getEventsList();

    @GetMapping("/findById/{id}")
    Event getEventById(@PathVariable String id);

    @GetMapping("/findByLessonId/{id}")
    List<Event> getEventsByLessonId(@PathVariable String id);

    @GetMapping("/all-event-attendances")
    List<EventAttendanceFact> getEventAttendanceFactList();

    @PutMapping("/auto-attendance")
    void autoAttendance(@RequestBody AutoAttendanceRequest body);
}
