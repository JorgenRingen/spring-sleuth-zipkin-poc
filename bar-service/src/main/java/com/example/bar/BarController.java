package com.example.bar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class BarController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BarController.class);

	@Autowired
	private BarService barService;

	@GetMapping
	public String bar() {
		LOGGER.info("BarController#bar received request");
		return barService.bar();
	}
}
