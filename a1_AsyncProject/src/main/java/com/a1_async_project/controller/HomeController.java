package com.a1_async_project.controller;

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
		return "enter /huge";
	}

	@GetMapping("/huge")
	public String getHuge() {
		return helloService.getHuge();
	}

}
