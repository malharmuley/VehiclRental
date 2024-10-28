package com.cg.ovms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class OvmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OvmsApplication.class, args);
	}

}
