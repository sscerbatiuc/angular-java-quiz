package com.step.quiz.app.rest.exception;

public class QuestionNotFoundException extends Exception {

  public QuestionNotFoundException(Long id) {
    super(String.format("Cannot find Question with %d", id));
  }
}
