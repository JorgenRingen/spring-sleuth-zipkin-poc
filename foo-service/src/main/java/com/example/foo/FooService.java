package com.example.foo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FooService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FooService.class);

	private final Tracer tracer;
	private final RestTemplate restTemplate;

	@Autowired
	public FooService(Tracer tracer,
					  RestTemplate restTemplate) {
		this.tracer = tracer;
		this.restTemplate = restTemplate;
	}

	public String getBarMessage() {
		LOGGER.info("Inside getBarMessage");
		String barMessage = getMessageFromBarService();
		LOGGER.info("Exiting getBarMessage");
		return barMessage;
	}

	private String getMessageFromBarService() {
		Span getBarSpan = tracer.createSpan("fooLogic-span");
		LOGGER.info("Calling bar-service to get message");
		String barMessage = restTemplate.getForObject("http://localhost:9002", String.class);
		LOGGER.info("Received message='{}' from barService", barMessage);
		tracer.close(getBarSpan);
		return barMessage;
	}
}
