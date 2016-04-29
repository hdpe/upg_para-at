package com.upgplc.para_at.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	
	public void start(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	public static void main(String[] args) {
		new Application().start(args);
	}
}
