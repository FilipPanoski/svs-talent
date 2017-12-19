import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { ActiveuserComponent } from '../activeuser.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService: LoginService, private router: Router) { }

  email: string;
  response: Boolean;
  invalidAccount: Boolean = false;
  invalidAccountMessage = 'Invalid account! Try again or create an account.';

  ngOnInit() {
  }

  loginUser() {
    this.invalidAccount = false;
    this.loginService.loginUser(this.email).subscribe(data => {
       this.response = data;
       if (this.response === true) {
        ActiveuserComponent.ACTIVE_USER = this.email;
        this.router.navigate(['/home']);
       } else {
        this.invalidAccount = true;
       }
       });
  }

}
