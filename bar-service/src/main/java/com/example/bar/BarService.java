package com.example.bar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BarService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BarController.class);

	public String bar() {
		LOGGER.info("BarService#bar");
		return "bar @ " + System.currentTimeMillis();
	}

}
