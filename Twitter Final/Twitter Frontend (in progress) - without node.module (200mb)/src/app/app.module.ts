import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';


import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';

import { RouterModule } from '@angular/router';
import { SignupComponent } from './signup/signup.component';

import { SignupService } from './signup.service';
import { LoginService } from './login.service';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { UsersService } from './users.service';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    HomeComponent,
    HeaderComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot([
      {path: '', component: LoginComponent},
      {path: 'signup', component: SignupComponent},
      {path: 'home', component: HomeComponent}
    ])
  ],
  providers: [
    SignupService,
    LoginService,
    UsersService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
