import { Component, OnInit } from '@angular/core';
import {QuizService} from '../shared/quiz.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {


  constructor(public quizService: QuizService, private router: Router) { }

  ngOnInit(): void {
    this.quizService.seconds = 0;
    this.quizService.currentQuestion = 0;
    this.quizService.getQuestions().subscribe((data: any) => {
      this.quizService.questions = data;
      this.quizService.startTimer();
    });
  }
}
