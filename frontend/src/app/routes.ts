import {Routes} from '@angular/router';
import {RegistrationComponent} from './registration/registration.component';
import {QuizComponent} from './quiz/quiz.component';
import {ResultComponent} from './result/result.component';
import {AuthGuard} from './auth/auth.guard';

export const appRoutes: Routes = [
  {path: 'register', component: RegistrationComponent},
  {path: 'quiz', component: QuizComponent, canActivate: [AuthGuard]},
  {path: 'result', component: ResultComponent, canActivate: [AuthGuard]},
  {path: '', redirectTo: '/register', pathMatch: 'full'}
];
