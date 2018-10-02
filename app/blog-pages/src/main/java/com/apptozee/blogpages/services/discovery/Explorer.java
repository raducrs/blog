package com.apptozee.blogpages.services.discovery;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

@Component
class Explorer {

    @JsonIgnoreProperties(ignoreUnknown=true)
    public static class Empty{
    }

    private String routesEndpoint;

    public String getRoutesEndpoint() {
        return routesEndpoint;
    }

    public void setRoutesEndpoint(String routesEndpoint) {
        this.routesEndpoint = routesEndpoint;
    }

    public CollectionLinks explore(String serviceName) {
        return exploreAll().get(serviceName);
    }

    public Map<String, CollectionLinks> exploreAll() {
        ResponseEntity<RoutesList> routesListResponseEntity = new RestTemplate().getForEntity(routesEndpoint + "/actuator/routes/details", RoutesList.class);
        if (routesListResponseEntity.getStatusCode() != HttpStatus.OK){
            return Collections.emptyMap();
        }
        return routesListResponseEntity.getBody().getRoutes().entrySet().stream()
                .map( entry -> new Tuple2<>(toServiceName(entry.getValue()), toCollectionLinks(entry.getValue())))
                .filter(tuple -> tuple.getValue() != null)
                .collect(Collectors.toMap(Tuple2::getKey,Tuple2::getValue));
    }

    private String toServiceName(Route route) {
        return route.getLocation();
    }

    private CollectionLinks toCollectionLinks(Route route) {
        try {
            ResponseEntity<Resource<Empty>> rootResponseEntity = new RestHalTemplate().exchange(routesEndpoint + route.getPrefix(), HttpMethod.GET, null,
                    new ParameterizedTypeReference<Resource<Empty>>() {});
            if (rootResponseEntity.getStatusCode() != HttpStatus.OK){
                return null;
            }

            Map<String,Links> collectionLinksList = rootResponseEntity.getBody().getLinks().stream()
                    .collect(Collectors.toMap(Link::getRel, link -> new Links(link.getHref())));

            return new CollectionLinks(collectionLinksList);
        } catch (Exception e){
            return null;
        }

    }


}
