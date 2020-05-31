package com.step.quiz.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class QuizApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizApiApplication.class, args);
	}

}
