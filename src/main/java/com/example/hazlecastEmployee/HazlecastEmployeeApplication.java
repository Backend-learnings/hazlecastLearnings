package com.example.hazlecastEmployee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//@EnableWebMvc
//@EnableSwagger2
@EnableCaching
@SpringBootApplication
public class HazlecastEmployeeApplication {
	public static void main(String[] args) {
		SpringApplication.run(HazlecastEmployeeApplication.class, args);
	}
}
