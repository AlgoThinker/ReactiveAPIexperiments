package com.webfluxpoc.callerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class CallerserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CallerserviceApplication.class, args);
	}

}
