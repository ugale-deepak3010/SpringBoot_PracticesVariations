package com.a1_async_project.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

	public String getHuge() {

		return "ohh too many process after we loaded this huge data...!";
	}

}
