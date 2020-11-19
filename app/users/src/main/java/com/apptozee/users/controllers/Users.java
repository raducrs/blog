package com.apptozee.users.controllers;

import com.apptozee.users.models.User;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(Users.class)
@RequestMapping("/users")
public class Users {


    public Resources<User> getUsers(@RequestParam(value = "start", required = false) Integer start, @RequestParam(value = "size", required = false) Integer size,
                                    @RequestParam(value = "sortDirection", required = false) String sortDirectionStr, @RequestParam(value = "sortBy" , required = false) String sortBy) {
        return null;
    }


}
