package com.journal.periodplanning.adapters.database;

import com.journal.periodplanning.domain.Lesson;
import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, String> {

    Lesson findLessonByLessonId(String id);

    Iterable<Lesson> findAll();
}
