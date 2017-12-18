import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService: LoginService) { }

  email: string;
  errors: any;

  ngOnInit() {
  }

  loginUser() {
    this.loginService.loginUser(this.email).subscribe(error => this.errors = error);
  }

}
