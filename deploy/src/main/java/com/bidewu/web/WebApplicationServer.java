package com.bidewu.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.bidewu.web"})
@EnableCaching
public class WebApplicationServer {

	public static void main(String[] args) {
		SpringApplication.run(WebApplicationServer.class, args);
	}

}
