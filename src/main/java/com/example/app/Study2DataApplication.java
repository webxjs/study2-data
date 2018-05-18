package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.example")
//@EntityScan("com.example.model")
//@EnableJpaRepositories(basePackages={"com.example.dao"})
public class Study2DataApplication {
	public static void main(String[] args) {
		SpringApplication.run(Study2DataApplication.class, args);
	}
}
