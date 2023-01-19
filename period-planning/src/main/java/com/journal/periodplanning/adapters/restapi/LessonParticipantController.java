package com.journal.periodplanning.adapters.restapi;

import com.journal.periodplanning.domain.LessonParticipant;
import com.journal.periodplanning.adapters.database.LessonParticipantRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class LessonParticipantController {

    private final LessonParticipantRepository lessonParticipantRepository;

    public LessonParticipantController(LessonParticipantRepository lessonParticipantRepository) {
        this.lessonParticipantRepository = lessonParticipantRepository;
    }

    @GetMapping("/listParticipants")
    public Iterable<LessonParticipant> getParticipantList() {
        return lessonParticipantRepository.findAll();
    }


    @GetMapping("/findLessonByLesson/{id}")
    public Iterable<LessonParticipant> findParticipantsByLessonId(@PathVariable String id) {
        return lessonParticipantRepository.findLessonByLessonId(id);
    }

    @GetMapping("/findLessonByPerson/{id}")
    public Iterable<LessonParticipant> findParticipantsByPersonId(@PathVariable String id) {
        return lessonParticipantRepository.findLessonByPersonId(id);
    }

}
