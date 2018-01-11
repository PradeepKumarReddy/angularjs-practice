import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-about-us',
  templateUrl: './about-us.component.html',
  styleUrls: ['./about-us.component.css']
})
export class AboutUsComponent implements OnInit {

  aboutUsDesc = 'This site is under construction, We will come soon';	
  constructor() { }

  ngOnInit() {
  }

}
