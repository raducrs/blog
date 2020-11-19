package com.apptozee.users.controllers;

import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class RootController implements ResourceProcessor<RepositoryLinksResource> {

    public static final String USERS = "users";

    @Override
    public RepositoryLinksResource process(RepositoryLinksResource repositoryLinksResource) {
        repositoryLinksResource.add( ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(Users.class).getUsers(null,null,null, null))
                .withRel(USERS));
        return repositoryLinksResource;
    }
}
