package com.programs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.function.client.WebClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(basePackages= {"com.programs.model", "com.programs.repository", "com.programs.controller", "com.programs.service", "com.programs.exceptions","com.programs.configuration"})
@SpringBootApplication
@EnableSwagger2
public class WebClientTrials1Application {

	@Bean
	public WebClient.Builder getWebClientBuilder()
	{
		return WebClient.builder();
	}
	public static void main(String[] args) {
		SpringApplication.run(WebClientTrials1Application.class, args);
		System.out.println("Check postman with the following requests \n"+
				"GET	http://localhost:8090/studentCourses/courses \n"+
				"GET	http://localhost:8090/studentCourses/courses{courseId} \n"+
				"GET	http://localhost:8090/studentCourses/{studentId}/courses \n"+
				"POST	http://localhost:8090/studentCourses/courses");
		
	}

}
