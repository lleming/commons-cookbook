package org.example.freemarker;

import java.util.List;

public class Enrollment {

  private Student student;
  private Course course;
  private List exams;
  private String section;

  public Enrollment() {
  }

  public Enrollment(Student student, Course course, List exams, String section) {
    this.student = student;
    this.course = course;
    this.exams = exams;
    this.section = section;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public List getExams() {
    return exams;
  }

  public void setExams(List exams) {
    this.exams = exams;
  }

  public String getSection() {
    return section;
  }

  public void setSection(String section) {
    this.section = section;
  }
}
