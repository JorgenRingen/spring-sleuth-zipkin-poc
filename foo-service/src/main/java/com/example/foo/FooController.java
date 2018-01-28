package com.example.foo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FooController.class);

	@Autowired
	private FooService fooService;

	@GetMapping
	public String foo() {
		LOGGER.info("FooController#foo");
		String message = fooService.getBarMessage();
		return "foo @ " + System.currentTimeMillis() + " " + message;
	}
}
