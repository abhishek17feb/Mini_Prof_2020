import { Component, OnInit, ViewChild } from '@angular/core';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {

  @ViewChild("userName",{ static : false }) userName : string;
  @ViewChild("password",{ static : false }) password : string;

  constructor( private userService : UserServiceService ) { }

  ngOnInit() {
    this.userService.sayHello().subscribe(
      (response) => {
        console.log(response);
      }
    );
  }

  login(){
    this.userService.login( this.userName,this.password ).subscribe(
      (response) => {
        console.log(response);
      }
    );
   
      
  }

}
