package com.cosmos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AsyncCosmosClientLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncCosmosClientLibraryApplication.class, args);
		System.out.println("http://localhost:8080/swagger-ui/#/student-reactive-controller");
	}

}
