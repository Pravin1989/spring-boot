package com.springmvc.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class CRUDSpring4Application extends SpringBootServletInitializer{

	public static void main(String[] args) {
		//SpringApplication.run(CRUDSpring4Application.class, args);
		SpringApplication app=new SpringApplication(CRUDSpring4Application.class);
		System.out.println(app.isWebEnvironment());
		app.run(args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CRUDSpring4Application.class);
	}
}