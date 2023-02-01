package org.example;

import java.util.List;

public class ExamResults {

  private Long id;
  private final int[] scores;
  private final List students;

  public ExamResults(long id, int[] scores, List students) {
    this.id = id;
    this.scores = scores;
    this.students = students;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int[] getScores() {
    return scores;
  }

  public List getStudents() {
    return students;
  }
}
