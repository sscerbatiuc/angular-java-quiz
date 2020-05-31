import {Routes} from '@angular/router';
import {RegistrationComponent} from './registration/registration.component';
import {QuizComponent} from './quiz/quiz.component';
import {ResultComponent} from './result/result.component';

export const appRoutes: Routes = [
  {path: 'register', component: RegistrationComponent},
  {path: 'quiz', component: QuizComponent},
  {path: 'result', component: ResultComponent},
  {path: '', redirectTo: '/register', pathMatch: 'full'}
];
