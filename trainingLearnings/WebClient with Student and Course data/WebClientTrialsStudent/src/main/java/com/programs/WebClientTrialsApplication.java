package com.programs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.function.client.WebClient;

@ComponentScan(basePackages= {"com.programs.controller", "com.programs.model", "com.programs.repository", "com.programs.service" , "com.programs.exceptions"})
@SpringBootApplication
public class WebClientTrialsApplication {

	
//	public WebClient.Builder getWebClientBuilder()
//	{
//		return WebClient.builder();
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(WebClientTrialsApplication.class, args);
		System.out.println("Check postman or \n http://localhost:8091/swagger-ui/#/student-controller");
	}

}


