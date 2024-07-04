package com.hglam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hglam"})

public class OnionApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnionApplication.class, args);
	}

}
