package com.abhi.app.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MyEncoder {

	@Bean
	public PasswordEncoder encode() {
		return new BCryptPasswordEncoder(10);
	}
	
}
