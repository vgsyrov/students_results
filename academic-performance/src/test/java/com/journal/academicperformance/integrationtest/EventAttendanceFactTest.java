package com.journal.academicperformance.integrationtest;

import com.journal.academicperformance.adapters.eventlistener.EventAttendanceFactMessage;
import com.journal.academicperformance.domain.Result;
import com.journal.academicperformance.domain.ResultType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventAttendanceFactTest extends AbstractTestBase {

    @Value("classpath:mockdata/event-attendance-fact-present.json")
    private Resource presentEventAttendanceFactMessageMock;

    @Value("classpath:mockdata/event-attendance-fact-absent.json")
    private Resource absentEventAttendanceFactMessageMock;

    @Test
    @DisplayName("Проверить, что входящее сообщение создает результат с типом автобалл и значением 1")
    void onSetEventAttendanceFactMessage() throws IOException {

        // given
        var event = objectMapper.readValue(presentEventAttendanceFactMessageMock.getInputStream(), EventAttendanceFactMessage.class);

        // when
        eventListener.onMessage(event);

        // then
        var results = fromIterator(resultRepository.findResultsByLessonId("l-1"));
        assertEquals(1, results.size());

        Result result = results.get(0);
        assertEquals("p-1", result.getPersonId());
        assertEquals("l-1", result.getLessonId());
        assertEquals(ResultType.AUTO_ATTENDANCE, result.getResultType());
        assertEquals("1", result.getValue());
    }

    @Test
    @DisplayName("Проверить, что входящее сообщение удаляет созданный ранее результат")
    void onClearEventAttendanceFactMessage() throws IOException {

        // given
        var eventPresent = objectMapper.readValue(presentEventAttendanceFactMessageMock.getInputStream(), EventAttendanceFactMessage.class);
        eventListener.onMessage(eventPresent);
        var eventAbsent = objectMapper.readValue(absentEventAttendanceFactMessageMock.getInputStream(), EventAttendanceFactMessage.class);

        // when
        eventListener.onMessage(eventAbsent);

        // then
        var results = fromIterator(resultRepository.findResultsByLessonId("l-1"));
        assertEquals(0, results.size());
    }
}
