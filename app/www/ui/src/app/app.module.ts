import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { NavbarSearchComponent } from './navbar-search/navbar-search.component';
import { NavbarSignInComponent } from './navbar-sign-in/navbar-sign-in.component';
import {BlogListingComponent, FeaturedHeadingComponent, FeaturedEntryComponent} from './blog-listing/blog-listing.component';
import { HomePageComponent } from './home-page/home-page.component';
import { RoutingModule } from './routing.module';

import { FooterComponent } from './footer/footer.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    NavbarSearchComponent,
    NavbarSignInComponent,

    BlogListingComponent,
    FeaturedHeadingComponent,
    FeaturedEntryComponent,

    HomePageComponent,

    FooterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    NgbModule.forRoot(),
    RoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
