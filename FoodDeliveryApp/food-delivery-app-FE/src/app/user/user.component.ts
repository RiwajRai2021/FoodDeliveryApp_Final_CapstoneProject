import { Component } from '@angular/core';
import { NgModel } from '@angular/forms';
import { UserService } from './user.service';
import { error } from 'console';
import { Router } from '@angular/router';
import { StorageService } from '../utils/storage.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-user',
  standalone: false,
  
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent {

  loginData = {
    username: '',
    password: ''
  }

  constructor(private userService: UserService, private route: Router, private localStorage: StorageService, private toastr: ToastrService) {}

  onSubmit() {
    this.userService.loginURL(this.loginData.username, this.loginData.password).subscribe(
      (res: any) => {
        this.localStorage.setItem('user', res);
        this.toastr.success("Successful", "Login", {
          timeOut: 3000,
          positionClass: 'toast-bottom-right'
        })
        if(res['role'] == "Customer") {
          this.route.navigate(['/restaurant-listing']);
        } else {
          this.route.navigate(['/details']);
        }
      }, (error) => {
        console.log("Error : {}", error)
        this.toastr.error("Failure", "Login", {
          timeOut: 3000,
          positionClass: 'toast-bottom-right'
        })
      }
    )
  }

}
