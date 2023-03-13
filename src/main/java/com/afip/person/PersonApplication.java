package com.afip.person;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersonApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(PersonApplication.class);
		springApplication.setDefaultProperties(Collections.singletonMap("server.port", "8090"));
		springApplication.run(args);
		// SpringApplication.run(PersonApplication.class, args);
	}

}
