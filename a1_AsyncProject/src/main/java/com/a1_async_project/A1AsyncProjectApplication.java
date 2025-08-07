package com.a1_async_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


// Enable Async Added.

//Do not call the method from inside the same class, otherwise Spring won’t proxy the method and it won’t run asynchronously.
@SpringBootApplication
@EnableAsync
public class A1AsyncProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(A1AsyncProjectApplication.class, args);
	}

}
