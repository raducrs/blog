import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { NavbarSearchComponent } from './navbar-search/navbar-search.component';
import { NavbarSignInComponent } from './navbar-sign-in/navbar-sign-in.component';
import { BlogListingComponent } from './blog-listing/blog-listing.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    NavbarSearchComponent,
    NavbarSignInComponent,
    BlogListingComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    NgbModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
