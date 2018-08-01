import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomePageComponent} from './home-page/home-page.component';
import {BlogListingComponent} from './blog-listing/blog-listing.component';

const routes: Routes = [
    { path: 'home', component: HomePageComponent },
    { path: 'blog', component: BlogListingComponent},
    { path: '', redirectTo: '/home', pathMatch: 'full' }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [
      RouterModule
  ],
  declarations: []
})
export class RoutingModule { }
