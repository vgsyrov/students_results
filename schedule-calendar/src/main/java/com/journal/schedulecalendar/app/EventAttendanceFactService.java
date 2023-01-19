package com.journal.schedulecalendar.app;

import com.journal.schedulecalendar.Entity.EventAttendanceFact;
import com.journal.schedulecalendar.eventpublisher.EventAttendanceFactMessage;
import com.journal.schedulecalendar.adapters.database.EventAttendanceFactRepository;
import com.journal.schedulecalendar.adapters.database.EventRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class EventAttendanceFactService {


    private final EventAttendanceFactRepository eventAttendanceFactRepository;
    private final EventRepository eventRepository;
    private final EventAttendanceFactPublisher eventAttendanceFactPublisher;

    public EventAttendanceFactService(EventAttendanceFactRepository eventAttendanceFactRepository,
                                      EventRepository eventRepository,
                                      EventAttendanceFactPublisher eventAttendanceFactPublisher) {
        this.eventAttendanceFactRepository = eventAttendanceFactRepository;
        this.eventRepository = eventRepository;
        this.eventAttendanceFactPublisher = eventAttendanceFactPublisher;
    }

    public void autoAttendance(@NonNull String personId, @NonNull String eventId, String attendanceFact) {
        EventAttendanceFact eventAttendanceFact = eventAttendanceFactRepository
                .findEventAttendanceFactByEventIdAndPersonId(
                        eventId,
                        personId
                );

        if(eventAttendanceFact == null){
            EventAttendanceFact newEventAttendanceFact = EventAttendanceFact.builder()
                    .eventId(eventId)
                    .personId(personId)
                    .attendanceFact(attendanceFact)
                    .build();
            eventAttendanceFactRepository.save(newEventAttendanceFact);
        } else {
            eventAttendanceFact.setAttendanceFact(attendanceFact);
            eventAttendanceFactRepository.save(eventAttendanceFact);
        }

        try {
            String lessonId = eventRepository.findEventByEventId(eventId).getLessonId();
            eventAttendanceFactPublisher.publish(personId, lessonId, attendanceFact);

        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public Iterable<EventAttendanceFact> getAllEventAttendanceFacts(){
        return eventAttendanceFactRepository.findAll();
    }
}
