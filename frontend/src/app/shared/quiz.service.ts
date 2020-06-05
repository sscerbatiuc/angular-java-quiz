import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  readonly rootUrl = '/api/v1';
  questions: any;
  seconds: number;
  timer: any;
  currentQuestion: number;

  constructor(private http: HttpClient, private router: Router) {
  }

  public displayElapsedTime() {
    return Math.floor(this.seconds / 3600) + ':' + Math.floor(this.seconds / 60) + ':' + Math.floor(this.seconds);
  }

  public startTimer() {
    this.timer = setInterval(() => {
      this.seconds++;
    }, 1000);
  }

  createParticipant(name: string, email: string) {
    const requestBody = {name, email};
    return this.http.post(this.rootUrl + '/participants', requestBody);
  }

  getQuestions() {
    return this.http.get(this.rootUrl + '/questions');
  }

  answer(option: number) {
    this.questions[this.currentQuestion].answer = option;
    this.currentQuestion++;
    if (this.currentQuestion === 9) {
      clearInterval(this.timer);
      this.router.navigate(['/result']);
    }
  }

  getResult() {
    let correct = 0;
    this.questions.forEach((q, idx) => {
      if (q.answer === q.correctAnswer) {
        correct ++;
      }
    });
    return correct;
  }
}
