import {Component, Input, OnInit} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';


import {BlogListingService} from '../services/blog-listing.service';
import {BlogEntryDetail} from '../models/BlogEntryDetail';


@Component({
  selector: 'app-blog-listing',
  templateUrl: './blog-listing.component.html',
  styleUrls: ['./blog-listing.component.css']
})
export class BlogListingComponent implements OnInit {

  blogEntries: BlogEntryDetail[] = null;
  blogNextLink = '/home';
  blogPrevLink = '';


  blogFeatureEntries: BlogEntryDetail[] = null;

  constructor(private blogListingService: BlogListingService,
              private route: ActivatedRoute,
              private location: Location) { }

  ngOnInit() {
    this.getBlogListing();
    this.getBlogFeatured();
  }

  getBlogListing(): void {
    const start = +this.route.snapshot.paramMap.get('start');
    const end = +this.route.snapshot.paramMap.get('end');
    this.blogListingService.getBlogEntries(start, end).subscribe( blogEntries => this.blogEntries = blogEntries);
  }

    getBlogFeatured(): void {
        this.blogListingService.getBlogFeatureEntries().subscribe( blogEntries => this.blogFeatureEntries = blogEntries);
    }
}


@Component({
    selector: 'app-featured-heading',
    templateUrl: './display/featured-heading.html',
    styleUrls: ['./display/featured-heading.css']
})
export class FeaturedHeadingComponent {
    @Input() model: BlogEntryDetail;
}

@Component({
    selector: 'app-featured-entry',
    templateUrl: './display/featured-entry.html',
    styleUrls: ['./display/featured-entry.css']
})
export class FeaturedEntryComponent {
    @Input() model: BlogEntryDetail;
}
