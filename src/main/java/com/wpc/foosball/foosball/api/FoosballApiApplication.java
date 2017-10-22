package com.wpc.foosball.foosball.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages="com.wpc.foosball.foosball")
@SpringBootApplication
public class FoosballApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoosballApiApplication.class, args);
	}
}
