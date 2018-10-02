package com.apptozee.blogpages.services.discovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class Discovery {

    private static final long DEFAULT_POLL_TIME_S = 60;
    @Autowired
    private DiscoveryConfiguration discoveryConfiguration;

    @Autowired
    private Explorer explorer;

    private Map<String,CollectionLinks> serviceCollections = new ConcurrentHashMap<>();

    public Discovery() {
    }

    @PostConstruct
    public void init(){
        // change to a factory
        explorer.setRoutesEndpoint(discoveryConfiguration.getRoutesEndpoint());

        // retrieve time delay
        long timeDelay = DEFAULT_POLL_TIME_S;
        try{
            timeDelay = Long.valueOf(discoveryConfiguration.getPollTimeSeconds());
        } catch (NumberFormatException e){

        }
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(this::update, 0, timeDelay, TimeUnit.SECONDS);
    }

    public Link getLinkFor(String serviceName, String collectionName, Object ... ids){

        CollectionLinks collectionsLink = serviceCollections.get(serviceName);

        if (collectionsLink == null){
            collectionsLink = explore(serviceName);
            if (collectionsLink != null) {
                addCollection(serviceName, collectionsLink);
            } else {
                return null;
            }

        }

        return collectionsLink.getCollection(collectionName, ids);
    }

    private void addCollection(String serviceName, CollectionLinks collectionsLink) {
        serviceCollections.put(serviceName,collectionsLink);
    }


    private CollectionLinks explore(String serviceName) {
        return explorer.explore(serviceName);
    }

    private Map<String,CollectionLinks> exploreAll(){
        return explorer.exploreAll();
    }

    private void update(){
        Map<String,CollectionLinks> newLinks = exploreAll();
        removeOutdatedServices(newLinks);
        newLinks.forEach( (serviceName, collectionLinks) -> serviceCollections.put(serviceName, collectionLinks));

        serviceCollections.entrySet().forEach(entry -> System.out.println(entry.getKey() + "->" + entry.getValue()));
    }

    private void removeOutdatedServices(Map<String,CollectionLinks> newLinks){
        Set<String> currentServices = serviceCollections.keySet();
        currentServices.removeAll(newLinks.keySet());
        currentServices.forEach( outdatedKeys -> serviceCollections.remove(outdatedKeys));
    }

}
