import { Component, OnInit } from '@angular/core';
import { SignupService } from '../signup.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private signupService: SignupService, private router: Router) { }

  email: string;
  response: Boolean = false;
  signupSucess = false;
  signupFail = false;
  signupMessage: string;

  ngOnInit() {
  }

  signupUser() {
    this.signupService.signupUser(this.email)
    .subscribe(data => {
       this.response = data;
       if (this.response === true) {
      console.log('true');
      this.signupSucess = true;
      this.signupFail = false;
      this.signupMessage = 'You successfully signed up...';
      setTimeout(() => this.router.navigate(['']), 2000);
    } else {
      console.log('false');
      this.signupFail = true;
      this.signupMessage = 'That account already exists! Try another one or log in.';
    } } );
  }
}
