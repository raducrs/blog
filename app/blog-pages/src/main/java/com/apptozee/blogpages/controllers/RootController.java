package com.apptozee.blogpages.controllers;

import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class RootController implements ResourceProcessor<RepositoryLinksResource> {

    public static final String PAGES = "pages";

    @Override
    public RepositoryLinksResource process(RepositoryLinksResource repositoryLinksResource) {
        repositoryLinksResource.add( ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(BlogPages.class).getBlogPages(null,null,null, null))
                .withRel(PAGES));
        return repositoryLinksResource;
    }
}
