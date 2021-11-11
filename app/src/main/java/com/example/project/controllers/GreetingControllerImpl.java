package com.example.project.controllers;

import com.domain.projectname.api.controllers.GreetingController;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.format;

@RestController
public class GreetingControllerImpl implements GreetingController {
	@Override
	public String greetWorld() {
		return "Hello, World!";
	}

	@Override
	public String greetHuman(String name) {
		return format("Hello, %s!", name);
	}

	@Override
	public String greetHumanPut(String name) {
		return name;
	}
}
