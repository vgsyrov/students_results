package com.journal.schedulecalendar.eventpublisher;

import com.journal.schedulecalendar.Entity.EventAttendanceFact;
import com.journal.schedulecalendar.app.EventAttendanceFactPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventAttendanceFactPublisherImpl implements EventAttendanceFactPublisher {

    @Value("${sc.attendance.queue.name}")
    private String QUEUE_NAME;

    private final RabbitTemplate template;

    public EventAttendanceFactPublisherImpl(RabbitTemplate template) {
        this.template = template;
    }


    @Override
    public void publish(String personId, String lessonId, String attendanceFact) {
        log.info("Отправлено сообщение об установке автобалла: person={} lesson={} attendanceFact={}",
                personId, lessonId, attendanceFact);
        template.convertAndSend(QUEUE_NAME, EventAttendanceFactMessage.builder()
                .lessonId(lessonId)
                .personId(personId)
                .attendanceFact(attendanceFact)
                .build());
    }
}
