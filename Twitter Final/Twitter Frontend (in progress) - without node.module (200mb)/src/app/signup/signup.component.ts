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
  errors: any;
  signupSucess = false;

  ngOnInit() {
  }

  signupUser() {
    this.signupService.signupUser(this.email).subscribe(error => this.errors = error);
    this.signupSucess = true;
    setTimeout(() => this.router.navigate(['']), 2000);
  }

}
