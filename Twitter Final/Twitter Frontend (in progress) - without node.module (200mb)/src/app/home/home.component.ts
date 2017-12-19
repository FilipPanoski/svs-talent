import { Component, OnInit } from '@angular/core';

import { HeaderComponent } from '../header/header.component';
import { UsersService } from '../users.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  users: any;

  constructor(private usersService: UsersService) { }

  ngOnInit() {
    this.loadUsers();
  }


  loadUsers() {
    this.usersService.getUsers()
    .subscribe(data => { this.users = data; });
  }

}
