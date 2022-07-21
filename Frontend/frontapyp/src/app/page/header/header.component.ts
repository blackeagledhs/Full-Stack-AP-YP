import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user.model';
import { UserService } from '../../service/user.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public user: User | undefined;
  public editUser: User | undefined;
  
  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.getUser();
  }

  public getUser(): void {
    this.userService.getUser().subscribe({
      next: (Response: User) => {
        this.user=Response;
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    })
  }

  public onEditUser(user: User): void {
    this.userService.editUser(user).subscribe({
      next: (Response: User) => {
        console.log(Response);
        this.getUser();
      },
      error: (error: HttpErrorResponse) =>{
        alert(error.message);
      }
    })
  }

  public onOpenModal(mode: string, user?: User): void {
    const container = document.getElementById('usermodal');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');    
    if (mode === 'edit') {
      this.editUser = user;
      button.setAttribute('data-target', '#editUserModal');
    }    
    container?.appendChild(button);
    button.click();
  }

}