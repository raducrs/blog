package com.apptozee.blogpages.controllers;

import com.apptozee.blogpages.models.BlogPage;
import com.apptozee.blogpages.services.RetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;


@RestController
public class BlogPages {

    @Autowired
    private RetrievalService retrievalService;

    @GetMapping("blog/pages")
    public Resources<BlogPage> getBlogPages(@RequestParam(value = "start", required = false) Integer start, @RequestParam(value = "size", required = false) Integer size,
                                            @RequestParam(value = "sortDirection", required = false) String sortDirectionStr, @RequestParam(value = "sortBy" , required = false) String sortBy){


        if (start == null){
            start = 0;
        }

        if (size == null){
            size = 10;
        }

        Sort.Direction sortDirection = Sort.Direction.fromOptionalString(sortDirectionStr).orElse(Sort.Direction.ASC);

        sortBy = sortBy == null ? "id" : sortBy;

        PageRequest pageRequest = PageRequest.of(start,size,sortDirection,sortBy);


        Page<BlogPage> blogPages = retrievalService.retrievePage(pageRequest);

        Resources<BlogPage> blogPageResource = new Resources<>(blogPages,Collections.emptyList());
        ControllerLinkBuilder linkToSelf = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getBlogPages(start,size,sortDirection.name(),sortBy));
        blogPageResource.add(linkToSelf.withSelfRel());

        if (blogPages.hasPrevious()){
            Pageable prev = blogPages.previousPageable();
            ControllerLinkBuilder linkToPrev = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass())
                    .getBlogPages((int) prev.getOffset(),prev.getPageSize(),sortDirection.name(),sortBy));
            blogPageResource.add(linkToPrev.withRel("prev"));
        }

        if (blogPages.hasNext()){
            Pageable next = blogPages.nextPageable();
            ControllerLinkBuilder linkToNext = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass())
                    .getBlogPages((int) next.getOffset(),next.getPageSize(),sortDirection.name(),sortBy));
            blogPageResource.add(linkToNext.withRel("next"));
        }


        return blogPageResource;
    }


    @GetMapping("blog/pages/{id:[0-9]+}")
    public Resource<BlogPage> getBlogPageById(@PathVariable("id") String pageId){
        BlogPage blogPage = retrievalService.getBlogPageById(Integer.valueOf(pageId));
        Resource<BlogPage> blogPageResource = new Resource<>(blogPage);
        ControllerLinkBuilder linkToSelf = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getBlogPageById(pageId));
        blogPageResource.add(linkToSelf.withSelfRel());
        return blogPageResource;
    }

    @PostMapping("blog/pages")
    @ResponseBody
    public BlogPage addBlogPage(@RequestBody BlogPage blogPage){
        return retrievalService.addBlogPage(blogPage);
    }

    @PutMapping("blog/pages/{id:[0-9]+}")
    @ResponseBody
    public BlogPage updateBlogPage(@RequestBody BlogPage blogPage, @PathVariable("id") String pageId){
        Integer idPage = Integer.valueOf(pageId);
        if (blogPage.getId() != null && !blogPage.getId().equals(idPage)){
            throw new IllegalArgumentException("The id set in the body does not match the resource id");
        }

        blogPage.setId(idPage);

        return retrievalService.updateBlogPage(blogPage);
    }

    @DeleteMapping("blog/pages/{id:[0-9]+}")
    public void deleteBlogPage(@PathVariable("id") String pageId){
        retrievalService.deleteBlogPage(Integer.valueOf(pageId));
    }
}
