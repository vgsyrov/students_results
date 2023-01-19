package com.journal.periodplanning.domain;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LESSON")
@EqualsAndHashCode(of = "lessonId")
@Data
public class Lesson {

  @Id
  @Column(name = "LESSON_ID", nullable = false)
  private String lessonId;

  @Column(name = "LESSON_NAME", nullable = false)
  private String lessonName;

}
