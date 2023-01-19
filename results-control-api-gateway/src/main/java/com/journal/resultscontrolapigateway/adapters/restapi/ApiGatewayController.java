package com.journal.resultscontrolapigateway.adapters.restapi;

import com.journal.resultscontrolapigateway.adapters.restclients.AcademicPerformanceClient;
import com.journal.resultscontrolapigateway.adapters.restclients.PeriodPlaningClient;
import com.journal.resultscontrolapigateway.adapters.restclients.PersonalInfoClient;
import com.journal.resultscontrolapigateway.adapters.restclients.ScheduleCalendarClient;
import com.journal.resultscontrolapigateway.AttendanceFactMapper;
import com.journal.resultscontrolapigateway.domain.AutoAttendanceRequest;
import com.journal.resultscontrolapigateway.domain.Lesson;
import com.journal.resultscontrolapigateway.domain.Person;
import com.journal.resultscontrolapigateway.domain.Result;
import io.reactivex.Observable;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class ApiGatewayController {

    private final PersonalInfoClient personalInfoClient;

    private final PeriodPlaningClient periodPlaningClient;

    private final AcademicPerformanceClient academicPerformanceClient;

    private final ScheduleCalendarClient scheduleCalendarClient;

    public ApiGatewayController(PersonalInfoClient personalInfoClient, PeriodPlaningClient periodPlaningClient, AcademicPerformanceClient academicPerformanceClient, ScheduleCalendarClient scheduleCalendarClient) {
        this.personalInfoClient = personalInfoClient;
        this.periodPlaningClient = periodPlaningClient;
        this.academicPerformanceClient = academicPerformanceClient;
        this.scheduleCalendarClient = scheduleCalendarClient;
    }


    @ApiOperation(value = "Установка посещения студентом занятия (снятие отметки)",
            notes = "Для установки признака посещения параметр attendanceFact равным П - или Н - для прогула")
    @RequestMapping(method={RequestMethod.POST,RequestMethod.PUT},
            path="/auto-attendance",
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public void autoAttendance(@RequestBody AutoAttendanceRequest body) {
        String mappedAttendance = mapAttendanceFactValue(body.getAttendanceFact());
        if(mappedAttendance != null){
            body.setAttendanceFact(mappedAttendance);
            scheduleCalendarClient.autoAttendance(body);
        }
    }


    @ApiOperation(value = "Журнал посещений",
            notes = "Отображение журнала посещения лекции с оценками")
    @GetMapping("/lessonResults/{eventId}")
    public Observable<List<Result>> getEventResults(@PathVariable @ApiParam(value = "ID события", example = "initialEvent_1") String eventId) {
        Observable<List<Person>> persons = Observable.just(personalInfoClient.getPersonalInfoNB());
        Observable<List<Lesson>> lessons = Observable.just(periodPlaningClient.getLessonList());
        Observable<List<Result>> results = Observable.just(academicPerformanceClient.findResultByLessonId(eventId));



        return Observable.zip(persons, lessons, results,
                        this::combineEventResults)
                .cache();
    }


    private List<Result> combineEventResults(List<Person> personJsons,
                                             List<Lesson> lessons,
                                             List<Result> results){


        Map<String, Person> personMap = new HashMap<>(personJsons.size());
        Map<String, Lesson> lessonMap = new HashMap<>(lessons.size());

        personJsons.forEach(item -> personMap.put(item.getPersonId(), item));
        lessons.forEach(item -> lessonMap.put(item.getLessonId(), item));

        results.stream()
                .peek(item -> item.setPersonName(personMap.get(item.getPersonId()).getFullName()))
                .forEach(item -> item.setLessonName(lessonMap.get(item.getLessonId()).getLessonName()));

        return results;

    }

    private String mapAttendanceFactValue(String incomingAttendanceFact){
        return AttendanceFactMapper.mapValue(incomingAttendanceFact);
    }

}
