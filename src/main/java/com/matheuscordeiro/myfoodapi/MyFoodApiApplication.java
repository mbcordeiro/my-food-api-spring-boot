package com.matheuscordeiro.myfoodapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class MyFoodApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFoodApiApplication.class, args);
	}

}
