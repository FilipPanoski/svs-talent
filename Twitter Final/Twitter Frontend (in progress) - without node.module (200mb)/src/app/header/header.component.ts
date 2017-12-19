import { Component, OnInit } from '@angular/core';
import { ActiveuserComponent } from '../activeuser.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  logoutUser() {
    ActiveuserComponent.ACTIVE_USER = null;
    this.router.navigate(['login']);
  }

}
