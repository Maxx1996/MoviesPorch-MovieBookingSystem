import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserLoginComponent } from './components/user-login/user-login.component';
import { ErrorComponent } from './components/error/error.component';
import { MoviesComponent } from './components/movies/movies.component';


const routes: Routes = [
  {path : 'UserLogin', component : UserLoginComponent},
  {path : 'ListOfMovies', component : MoviesComponent},
  {path : '**', component : ErrorComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
