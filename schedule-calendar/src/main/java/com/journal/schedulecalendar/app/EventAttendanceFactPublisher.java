package com.journal.schedulecalendar.app;

import com.journal.schedulecalendar.Entity.EventAttendanceFact;
import com.journal.schedulecalendar.eventpublisher.EventAttendanceFactMessage;

public interface EventAttendanceFactPublisher {
    void publish(String personId, String lessonId, String attendanceFact);
}
