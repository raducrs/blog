package com.apptozee.blogpages.services.discovery;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

class RoutesList {

    private Map<String,Route> routes = new HashMap<>();

    @JsonAnySetter
    public void addRoutes(String serviceName, Route route){
        routes.put(serviceName,route);
    }

    public Map<String, Route> getRoutes() {
        return routes;
    }
}
