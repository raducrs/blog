import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { BlogEntryDetail } from '../models/BlogEntryDetail';

const MOCK_BLOG_ENTRIES: BlogEntryDetail[] = [
  {  id: 1,  title: 'blog 1', snipet: 'a small text asdd', snipet_image: '', keywords: ['a', 'b'], dateCreated : null, links: { __self: '#'} },
  {  id: 2,  title: 'blog 2', snipet: 'a small text 2',  snipet_image: '', keywords: ['c', 'd'], dateCreated : null, links: { __self: '#'} },
]

const blogDetail = 'localhost/blog/posts';

@Injectable({
  providedIn: 'root'
})
export class BlogListingService {

  constructor() { }

  getBlogEntries(start: number, end: number): Observable<BlogEntryDetail[]>  {
    return of(MOCK_BLOG_ENTRIES);
  }


  getBlogFeatureEntries() {
    return of(MOCK_BLOG_ENTRIES);
  }
}
