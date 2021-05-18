package com.blob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AzureSynchronousBlobApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AzureSynchronousBlobApplication.class, args);
		System.out.println("http://localhost:8080/swagger-ui/");
	}

}
