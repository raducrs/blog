package com.apptozee.apigateway;

import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationProperties {

//    @Bean
//    public PatternServiceRouteMapper serviceRouteMapper() {
//        return new PatternServiceRouteMapper(
//                "(?<name>^.+)-(?<version>v.+$)",
//                "${version}/${name}"){
//
////            @Override
////            public String apply(final String serviceId) {
////                String route =  super.apply(serviceId);
////                System.out.println(serviceId + " -> " +route);
////                return route;
////            };
//
//        };
//    }
}
