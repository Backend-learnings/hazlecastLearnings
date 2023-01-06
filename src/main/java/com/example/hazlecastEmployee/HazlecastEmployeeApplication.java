package com.example.hazlecastEmployee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
public class HazlecastEmployeeApplication {
	public static void main(String[] args) {
		SpringApplication.run(HazlecastEmployeeApplication.class, args);
	}
}
