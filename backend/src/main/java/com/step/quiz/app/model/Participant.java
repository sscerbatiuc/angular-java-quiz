package com.step.quiz.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "participant")
public class Participant {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @Column(name = "name", nullable = false)
  private String name;
  @Column(name = "email", nullable = false)
  private String email;
  @Column(name = "score")
  private int score;

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String lastName) {
    this.name = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }
}
