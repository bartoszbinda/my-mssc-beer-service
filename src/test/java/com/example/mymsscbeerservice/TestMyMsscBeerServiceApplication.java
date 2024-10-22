package com.example.mymsscbeerservice;

import org.springframework.boot.SpringApplication;

public class TestMyMsscBeerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(MyMsscBeerServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
