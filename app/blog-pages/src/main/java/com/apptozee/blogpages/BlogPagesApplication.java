package com.apptozee.blogpages;

import com.apptozee.blogpages.services.discovery.Discovery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.hateoas.Link;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.apptozee")
public class BlogPagesApplication {

	@Autowired
	private Discovery discovery;

	public static void main(String[] args) {
		SpringApplication.run(BlogPagesApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {
			Link link = discovery.getLinkFor("users-service","users",1);
			System.out.println(link.getHref());
		};
	}
}
