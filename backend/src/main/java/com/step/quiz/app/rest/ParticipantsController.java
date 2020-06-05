package com.step.quiz.app.rest;

import com.step.quiz.app.model.Participant;
import com.step.quiz.app.repository.ParticipantRepository;
import com.step.quiz.app.rest.exception.QuestionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/participants")
public class ParticipantsController {

  private final ParticipantRepository repository;

  @Autowired
  public ParticipantsController(ParticipantRepository repository) {
    this.repository = repository;
  }

  @GetMapping()
  public ResponseEntity<List<Participant>> getAll() {
    return ResponseEntity.ok().body(this.repository.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Participant> getById(@PathVariable("id") Long id) {
    Optional<Participant> participant = repository.findById(id);
    if (!participant.isPresent()) {
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
    return ResponseEntity.ok(participant.get());
  }

  @PostMapping()
  public ResponseEntity<Participant> create(@RequestBody Participant participant) {
    return ResponseEntity.ok(repository.save(participant));
  }

  @PutMapping("/{id}")
  public ResponseEntity update(@PathVariable("id") Long id,
                               @RequestBody Participant participant) {
    try {
      Participant edited = repository.findById(id).orElseThrow(() -> new QuestionNotFoundException(id));
      edited.setEmail(participant.getEmail());
      edited.setName(participant.getName());
      edited.setScore(participant.getScore());
      return ResponseEntity.ok(repository.save(edited));
    }
    catch (QuestionNotFoundException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable("id") Long id) {
    try {
      Participant question = repository.findById(id).orElseThrow(() -> new QuestionNotFoundException(id));
      repository.delete(question);
      return ResponseEntity.ok().build();
    }
    catch (QuestionNotFoundException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}
