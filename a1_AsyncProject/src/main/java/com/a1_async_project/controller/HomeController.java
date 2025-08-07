package com.a1_async_project.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.a1_async_project.service.HelloService;

@RestController
@RequestMapping("")
public class HomeController {

	@Autowired
	HelloService helloService;

	@GetMapping()
	public String getHome() {
		return "enter /huge-sync <br> /huge-async also /index.html";
	}

	@GetMapping("/fire")
	public String fireTest() {
		helloService.testAsyncFireForget();// not blocking the thread!!
		return "Fired!";
	}

	@GetMapping("/huge-sync")
	public String getHuge() {

		return helloService.getHuge_sync();
	}

	@GetMapping("/huge-async")
	public CompletableFuture<String> getMethodName() {
		helloService.getHugeAsync();

		return CompletableFuture.completedFuture("We will process your request. Thanks!");
	}

}
