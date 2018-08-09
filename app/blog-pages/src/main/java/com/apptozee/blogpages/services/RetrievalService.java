package com.apptozee.blogpages.services;

import com.apptozee.blogpages.models.BlogPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RetrievalService {

    BlogPage getBlogPageById(int pageId);

    BlogPage addBlogPage(BlogPage blogPage);

    Page<BlogPage> retrievePage(PageRequest pageRequest);

    BlogPage updateBlogPage(BlogPage blogPage);

    void deleteBlogPage(int pageId);
}
