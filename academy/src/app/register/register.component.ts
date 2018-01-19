import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor() { }

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
        console.log(this.model.firstName);
        console.log(this.model.lastName);
        console.log(this.model.dob);
        console.log(this.model.gender);
        console.log(this.model.username);
        console.log(this.model.password);
        /**this.userService.create(this.model)
            .subscribe(
                data => {
                    this.alertService.success('Registration successful', true);
                    this.router.navigate(['/login']);
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
                */
	}

}
