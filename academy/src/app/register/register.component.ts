import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { UserService } from '../webservices/user.service';
import { AlertService } from '../webservices/alert.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private router: Router,
        private userService: UserService, 
        private alertService: AlertService) { }

  ngOnInit() {
  }
    calendarImage = 'assets/images/calendar.png';
    model: any = {};
    loading = false;

    /**constructor(
        private router: Router,
        private userService: UserService,
        private alertService: AlertService) { }
        */


    register() {
        this.loading = true;
        this.userService.create(this.model)
            .subscribe(
                data => {
                    this.alertService.success('Registration successful', true);
                    console.log("success");
                    this.router.navigate(['/login']);
                },
               /** (err: HttpErrorResponse) => {
			      if (err.error instanceof Error) {
			        // A client-side or network error occurred. Handle it accordingly.
			        console.log('An error occurred:', err.error.message);
			      } else {
			        // The backend returned an unsuccessful response code.
			        // The response body may contain clues as to what went wrong,
			        console.log(`Backend returned code ${err.status}, body was: ${err.error}`);
			      }
			    });
			    */
               error => {
                    console.log("error");
                });
                
	}

	/**
    register() {
        this.loading = true;
        console.log(this.model.firstName);
        console.log(this.model.lastName);
        console.log(this.model.dob);
        console.log(this.model.gender);
        console.log(this.model.username);
        console.log(this.model.password);
        this.userService.create(this.model)
            .subscribe(
                data => {
                    this.alertService.success('Registration successful', true);
                    this.router.navigate(['/login']);
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
                
	}
	*/

}
