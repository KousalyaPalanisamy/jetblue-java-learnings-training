package com.programs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.function.client.WebClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@ComponentScan(basePackages= {"com.programs.dbConnections", "com.programs.controllers"})

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages= {"com.programs.exceptions", "com.programs.main", "com.programs.controllers", "com.programs.model", "com.programs.repository", "com.programs.service" })
public class WorkingWithDbsApplication implements CommandLineRunner
{

	public static void main(String[] args) {
		
		SpringApplication.run(WorkingWithDbsApplication.class, args);
		System.out.println("Check http://localhost:8090/swagger-ui/#/operations-controller/");
	}
	
	@Bean
	public WebClient.Builder getWebClientBuilder()
	{
		return WebClient.builder();
	}

	@Override
	public void run(String... args) throws Exception 
	{
		System.out.println("In main bean");	
	}

}
