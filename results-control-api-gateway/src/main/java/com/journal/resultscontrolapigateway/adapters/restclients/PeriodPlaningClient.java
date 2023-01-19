package com.journal.resultscontrolapigateway.adapters.restclients;

import com.journal.resultscontrolapigateway.domain.Lesson;
import com.journal.resultscontrolapigateway.domain.LessonParticipant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${pp.service.name}", url = "${pp.service.url}")
public interface PeriodPlaningClient {

    @GetMapping("/findLesson/{lessonId}")
    Lesson findLessonById(@PathVariable String lessonId);

    @GetMapping("/listLessons")
    List<Lesson> getLessonList();

    @GetMapping("/listPartiсipants")
    List<LessonParticipant> getListParticipants();

    @GetMapping("/findLessonByLesson/{lessonId}")
    List<LessonParticipant> findParticipantsByLessonId(@PathVariable String lessonId);

    @GetMapping("/findLessonByPerson/{personId}")
    List<LessonParticipant> findParticipantsByPersonId(@PathVariable String personId);

}
