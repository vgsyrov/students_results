package com.journal.periodplanning.adapters.database;

import com.journal.periodplanning.domain.LessonParticipant;
import com.journal.periodplanning.domain.LessonParticipantId;
import org.springframework.data.repository.CrudRepository;

public interface LessonParticipantRepository extends CrudRepository<LessonParticipant, LessonParticipantId> {
    Iterable<LessonParticipant> findLessonByLessonId(String id);

    Iterable<LessonParticipant> findLessonByPersonId(String id);

    Iterable<LessonParticipant> findAll();
}
