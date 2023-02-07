package org.example.freemarker;

import java.util.Date;

public class Exam {

  private String name;
  private Date date;
  private int score;
  private double weight;

  public Exam(String name, Date date, int score, double weight) {
    this.name = name;
    this.date = date;
    this.score = score;
    this.weight = weight;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }
}
