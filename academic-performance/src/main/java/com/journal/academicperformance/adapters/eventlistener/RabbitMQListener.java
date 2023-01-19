package com.journal.academicperformance.adapters.eventlistener;

import com.journal.academicperformance.app.AutoAttendanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class RabbitMQListener {

    private final AutoAttendanceService autoAttendanceService;

    public RabbitMQListener(AutoAttendanceService autoAttendanceService) {
        this.autoAttendanceService = autoAttendanceService;
    }

    @RabbitListener(queuesToDeclare = @Queue(name = "${sc.attendance.queue.name}", durable = "true"))
    public void onMessage(EventAttendanceFactMessage message){
        log.info("Получено сообщение об установке автобалла. PersonId={} LessonId={} attendanceFact={}",
                message.getPersonId(), message.getLessonId(), message.getAttendanceFact());
        autoAttendanceService.onMessage(message.getLessonId(), message.getPersonId(), message.getAttendanceFact());
    }
}
