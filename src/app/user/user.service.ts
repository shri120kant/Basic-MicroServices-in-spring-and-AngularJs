import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  
  uri="http://localhost:8080";

  constructor(private httpClient:HttpClient) { }
 
  getUser(userName):Observable<User>{
    return   this.httpClient.get<User>(`${this.uri}`+'/'+`${userName}`);   
  }
  
  getUsers():Observable<User[]>{
    return this.httpClient.get<User[]>(`${this.uri}`+'/users');
  }
}
export class User {
    _id?:number;
    user_name:string;
    password:string;
    _v?:number;
}
