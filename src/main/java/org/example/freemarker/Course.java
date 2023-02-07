package org.example.freemarker;

public class Course {

  private String name;
  private String dept;
  private String professor;
  private int num;

  public Course(String name, String professor, String dept, int num) {
    this.name = name;
    this.professor = professor;
    this.dept = dept;
    this.num = num;
  }

  public String getDept() {
    return dept;
  }

  public void setDept(String dept) {
    this.dept = dept;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getProfessor() {
    return professor;
  }

  public void setProfessor(String professor) {
    this.professor = professor;
  }
}
