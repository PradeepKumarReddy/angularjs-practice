import { Component, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';
import { Tab } from '../tab';

import { RouterModule, Routes, Router } from '@angular/router';
//import {Router} from "@angular/router";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})

@NgModule({
  imports: [
    RouterModule
  ]
})

// {name :'Login', link : '/login'}
export class DashboardComponent implements OnInit {
  tabs : Tab[];
  initial_tabs: Tab[] = [
  {name : 'Home', link : '/home'},
  {name : 'Services', link : '/services' },
  {name :'AboutUs', link : '/aboutus'}
  ]; 

  constructor(private router: Router) { }

  ngOnInit() {
  this.tabs = this.initial_tabs;
  }

  goHome() {
    this.router.navigate(['home']); 
  }

  goServices() {
    this.router.navigate(['services']); 
  }

  goAboutUs() {
    this.router.navigate(['aboutus']); 
  }

  onTabSelected(name) {
            console.log(" onTabSelected name " + name);
            switch (name) {
              case 'Home':
                this.router.navigate(['home']); 
                break;
              case 'Services':
                this.router.navigate(['services']); 
                break;
              case 'AboutUs':
                this.router.navigate(['aboutus']); 
                break;
              case 'Login':
                this.router.navigate(['login']); 
                break;
              default:
                this.router.navigate(['']); 
                break;
            }
    
  }

  navigateToLogin() {
    this.router.navigate(['/login']);
  }

/**
  DashboardComponent = function($scope, $location) {
        
        $scope.onTabSelected = function(tab) {
          var route;
          if (typeof tab === 'string') {
            switch (tab) {
              case 'dashboard':
                route = tab;
                break;
              default:
                route = 'rooms/' + tab;
                break;
            }
          }
          $location.path('/' + route);
        };

  getTabs(): string[] {
  	return this.tabs;
  }
  */

}
