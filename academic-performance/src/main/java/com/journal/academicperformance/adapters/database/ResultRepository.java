package com.journal.academicperformance.adapters.database;

import com.journal.academicperformance.domain.Result;
import com.journal.academicperformance.domain.ResultType;
import org.springframework.data.repository.CrudRepository;

public interface ResultRepository extends CrudRepository<Result, String> {

    Iterable<Result> findResultsByPersonId(String personId);

    Iterable<Result> findAll();

    Iterable<Result> findResultsByLessonId(String lessonId);

    Result findByLessonIdAndPersonIdAndResultType(String lessonId, String PersonId, ResultType resultType);
}
