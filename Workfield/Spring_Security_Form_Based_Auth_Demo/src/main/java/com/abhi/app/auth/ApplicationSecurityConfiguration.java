package com.abhi.app.auth;

import static com.abhi.app.auth.UserRole.ADMIN;
import static com.abhi.app.auth.UserRole.STUDENT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/v1/admin/**").hasRole(ADMIN.name())
			.antMatchers("/v1/student/**").hasRole(STUDENT.name())
			.anyRequest()
			.authenticated()
			.and()
			.formLogin();
	}
	
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		
		UserDetails abhishekUser = User.builder()
				.username("abhishek")
				.password(passwordEncoder.encode("password"))
				.roles(ADMIN.name()).build();

		UserDetails sumiUser = User.builder()
				.username("sumi")
				.password(passwordEncoder.encode("password"))
				.roles(STUDENT.name()).build();
		
		return new InMemoryUserDetailsManager( abhishekUser, sumiUser );
	}
	
}
