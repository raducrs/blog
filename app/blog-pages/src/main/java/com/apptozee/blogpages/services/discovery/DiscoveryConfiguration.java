package com.apptozee.blogpages.services.discovery;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "discovery")
public class DiscoveryConfiguration {

    @Value("${routes.endpoint:http://localhost:8765}")
    private String routesEndpoint;

    @Value("${routes.polltime.seconds:1}")
    private String pollTimeSeconds;

    public String getRoutesEndpoint() {
        return routesEndpoint;
    }

    public void setRoutesEndpoint(String routesEndpoint) {
        this.routesEndpoint = routesEndpoint;
    }

    public String getPollTimeSeconds() {
        return pollTimeSeconds;
    }

    public void setPollTimeSeconds(String pollTimeSeconds) {
        this.pollTimeSeconds = pollTimeSeconds;
    }
}
