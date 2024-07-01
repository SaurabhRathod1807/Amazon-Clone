	package com.amazon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class UserAmazonApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAmazonApplication.class, args);
	}

}
