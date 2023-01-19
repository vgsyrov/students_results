package com.journal.academicperformance.app;

import com.journal.academicperformance.adapters.database.ResultRepository;
import com.journal.academicperformance.domain.Result;
import org.springframework.stereotype.Component;

@Component
public class ResultService {
    private final ResultRepository resultRepository;

    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public Iterable<Result> findAll() {
        return resultRepository.findAll();
    }

    public Iterable<Result> findResultsByPersonId(String personId) {
        return resultRepository.findResultsByPersonId(personId);
    }

    public Iterable<Result> findResultsByLessonId(String lessonId) {
        return resultRepository.findResultsByLessonId(lessonId);
    }
}
