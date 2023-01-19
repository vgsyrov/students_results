package com.journal.periodplanning.adapters.restapi;

import com.journal.periodplanning.domain.Lesson;
import com.journal.periodplanning.adapters.database.LessonRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class LessonController {

    private final LessonRepository lessonRepository;

    public LessonController(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @GetMapping("/listLessons")
    public Iterable<Lesson> getLessonList() {
        Iterable<Lesson> ret = lessonRepository.findAll();
        return ret;
    }

    @GetMapping("/findLesson/{lessonId}")
    public Lesson findLessonEntityById(@PathVariable String lessonId) {
        return lessonRepository.findLessonByLessonId(lessonId);
    }

}
