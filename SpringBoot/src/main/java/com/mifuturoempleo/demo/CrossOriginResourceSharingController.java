package com.mifuturoempleo.demo;

import java.util.concurrent.atomic.AtomicLong;

import com.mifuturoempleo.resourcerepresentationclass.Greeting;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/cors")
public class CrossOriginResourceSharingController {

	private static final String template = "Hello, %s!";

	private final AtomicLong counter = new AtomicLong();
	@CrossOrigin(origins = "http://localhost:8082")
	@GetMapping("/greeting-javaconfig")
	public Greeting greeting(@RequestParam(required = false, defaultValue = "World") String name) {
		System.out.println("==== get greeting ====");
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

}