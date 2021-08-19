package org.training.microservices.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
	@RequestMapping(value = "/welcomePage", method = RequestMethod.GET)
	public String printMessage() {
		return "Welcome to world of Microservices...!!";
	}
}
