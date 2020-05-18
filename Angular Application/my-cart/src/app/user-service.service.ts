import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private httpClient : HttpClient) { }

  login( username : string, password : string ){
    return this.httpClient.put("http://localhost:8080/v1/user/student",{
      body : {
        "name" : "Aniket"
      }
    });
  }

  sayHello(){
    return this.httpClient.get("http://localhost:8080/v1/user/hello",{
      responseType : "text"
    });
  }



}
