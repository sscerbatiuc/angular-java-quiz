package com.step.quiz.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @Column(name = "title", nullable = false)
  private String question;
  @Column(name = "description", nullable = true)
  private String description;
  @Column(name = "option1", nullable = false)
  private String option1;
  @Column(name = "option2", nullable = false)
  private String option2;
  @Column(name = "option3", nullable = false)
  private String option3;
  @Column(name = "option4", nullable = false)
  private String option4;
  @Column(name = "correct_answer", nullable = false)
  private byte correctAnswer;

  public long getId() {
    return id;
  }

  public String getTitle() {
    return question;
  }

  public void setTitle(String question) {
    this.question = question;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getOption1() {
    return option1;
  }

  public void setOption1(String option1) {
    this.option1 = option1;
  }

  public String getOption2() {
    return option2;
  }

  public void setOption2(String option2) {
    this.option2 = option2;
  }

  public String getOption3() {
    return option3;
  }

  public void setOption3(String option3) {
    this.option3 = option3;
  }

  public String getOption4() {
    return option4;
  }

  public void setOption4(String option4) {
    this.option4 = option4;
  }

  public byte getCorrectAnswer() {
    return correctAnswer;
  }

  public void setCorrectAnswer(byte correctAnswer) {
    this.correctAnswer = correctAnswer;
  }
}
