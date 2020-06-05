import { Component, OnInit } from '@angular/core';
import {QuizService} from '../shared/quiz.service';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {

  constructor(public quizService: QuizService) { }

  ngOnInit(): void {
  }

}
