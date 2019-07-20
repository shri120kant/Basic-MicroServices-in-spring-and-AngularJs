import { Component, OnInit } from '@angular/core';
import { User, UserService } from './user.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  users:User[]=[];
  selectedUser:User;
  constructor(private route:ActivatedRoute,
    private service:UserService) { }

  ngOnInit() {
    this.service.getUsers()
    .subscribe(userList=>this.users=userList);
  }

  onSelection(user:User){
    this.selectedUser=user;
  }
}
