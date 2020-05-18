package com.abhi.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.abhi.app.repository")
public class MyCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCartApplication.class, args);
	}

}
