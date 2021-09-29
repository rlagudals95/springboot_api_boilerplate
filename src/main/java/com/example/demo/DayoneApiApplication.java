package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.dao","com.example.config", "com.example.sevice"})

public class DayoneApiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DayoneApiApplication.class, args);
	}

}

