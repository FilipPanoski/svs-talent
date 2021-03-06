import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { HttpParams, HttpClient } from '@angular/common/http';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()
export class SignupService {

  constructor(private http: Http) { }


  url = 'http://localhost:8080/signup';

  signupUser(email: string) {
    return this.http.post(this.url, email)
      .map((res: Response) => res.json())
      .catch((error: Response) => {
        return Observable.throw(error);
      });
  }

}
