package com.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	private static Logger logger = LoggerFactory
			.getLogger(WelcomeController.class);

	@RequestMapping("/CRUDSpring4")
	public String welcome() {
		logger.info("Welcome page is loaded");
		return "welcome";
	}
}