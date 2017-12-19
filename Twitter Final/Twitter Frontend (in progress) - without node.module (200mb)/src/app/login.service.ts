import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()
export class LoginService {

  constructor(private http: Http) { }

  url = 'http://localhost:8080/login';

  loginUser(email: string) {
     return this.http.get(this.url + '/?email=' + email)
      .map((res: Response) => res.json())
      .catch((error: Response) => {
        console.log('is working');
        return Observable.throw(error);
      });
  }

}
