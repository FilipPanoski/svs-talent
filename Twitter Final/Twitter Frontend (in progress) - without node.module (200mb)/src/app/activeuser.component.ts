import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-activeuser',
  templateUrl: './activeuser.component.html',
  styleUrls: ['./activeuser.component.css']
})
export class ActiveuserComponent implements OnInit {

  static ACTIVE_USER: string;

  constructor() { }

  ngOnInit() {
  }

}
