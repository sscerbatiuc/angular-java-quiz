package com.step.quiz.app.rest.exception;

public class ParticipantNotFoundException extends Exception {

  public ParticipantNotFoundException(Long id) {
    super(String.format("Cannot find Participant with %d", id));
  }
}
