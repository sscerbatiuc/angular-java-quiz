package com.step.quiz.app.rest;

import com.step.quiz.app.model.Question;
import com.step.quiz.app.repository.QuestionRepository;
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
@RequestMapping("/api/v1/questions")
public class QuestionsController {

  private final QuestionRepository repository;

  @Autowired
  public QuestionsController(QuestionRepository repository) {
    this.repository = repository;
  }

  @GetMapping()
  public ResponseEntity<List<Question>> getAll() {
    return ResponseEntity.ok().body(this.repository.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Question> getById(@PathVariable("id") Long id) {
    Optional<Question> questionById = repository.findById(id);
    if (!questionById.isPresent()) {
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
    return ResponseEntity.ok(questionById.get());
  }

  @PostMapping()
  public ResponseEntity<Question> create(@RequestBody Question question) {
    return ResponseEntity.ok(repository.save(question));
  }

  @PutMapping("/{id}")
  public ResponseEntity update(@PathVariable("id") Long id,
                               @RequestBody Question question) {
    try {
      Question edited = repository.findById(id).orElseThrow(() -> new QuestionNotFoundException(id));
      edited.setTitle(question.getTitle());
      edited.setDescription(question.getDescription());
      edited.setOption1(question.getOption1());
      edited.setOption2(question.getOption2());
      edited.setOption3(question.getOption3());
      edited.setOption4(question.getOption4());
      edited.setCorrectAnswer(question.getCorrectAnswer());
      return ResponseEntity.ok(repository.save(edited));
    }
    catch (QuestionNotFoundException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable("id") Long id) {
    try {
      Question question = repository.findById(id).orElseThrow(() -> new QuestionNotFoundException(id));
      repository.delete(question);
      return ResponseEntity.ok().build();
    }
    catch (QuestionNotFoundException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}
