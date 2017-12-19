import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';

import { Observable } from 'rxjs/Observable';



import 'rxjs/add/operator/map';

import 'rxjs/add/operator/catch';

@Injectable()
export class UsersService {

  constructor(private http: Http) { }


  url = 'http://localhost:8080/users';


  getUsers() {

    return this.http.get(this.url)
      .map((res: Response) => res.json())
      .catch((err: Response) => {
        return Observable.throw(err);
      });

  }

}
