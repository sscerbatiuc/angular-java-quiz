import { Component, OnInit } from '@angular/core';
import {QuizService} from '../shared/quiz.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  name = '';
  email = '';
  emailPattern = '^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$';

  constructor(private quizService: QuizService, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.quizService.createParticipant(this.name, this.email).subscribe((data: any) => {
      localStorage.clear();
      localStorage.setItem('participant', JSON.stringify(data));
      this.router.navigate(['/quiz']);
    });
  }

}
