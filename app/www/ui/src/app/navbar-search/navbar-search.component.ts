import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-app-navbar-search',
  templateUrl: './navbar-search.component.html',
  styleUrls: ['./navbar-search.component.css']
})
export class NavbarSearchComponent implements OnInit {

  results: string[] = ['a', 'b'];

  constructor() { }

  ngOnInit() {
  }

}
