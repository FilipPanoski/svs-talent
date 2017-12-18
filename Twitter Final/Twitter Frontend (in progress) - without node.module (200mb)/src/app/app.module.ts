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


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot([
      {path: '', component: LoginComponent},
      {path: 'signup', component: SignupComponent}
    ])
  ],
  providers: [
    SignupService,
    LoginService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
