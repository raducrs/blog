package com.apptozee.apigateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@ComponentScan(basePackages = "com.apptozee.apigateway")
public class ApiGatewayApplication {

	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext appContext) {
		return args -> {

			String[] beans = appContext.getBeanDefinitionNames();
			//Arrays.stream(beans).sorted().forEach(System.out::println);

		};
	}


}
