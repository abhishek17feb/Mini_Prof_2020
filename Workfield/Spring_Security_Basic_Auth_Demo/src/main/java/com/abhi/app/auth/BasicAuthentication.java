package com.abhi.app.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import static com.abhi.app.auth.ApplicationUserPermission.*;
import static com.abhi.app.auth.ApplicationUserRole.*;
@Configuration
@EnableWebSecurity
public class BasicAuthentication extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			csrf()
			.disable()
			.authorizeRequests()
			.antMatchers("/","index").permitAll()
			.antMatchers(HttpMethod.GET,"/v1/admin/**").hasAuthority(
					ADMIN_READ.name())
			.antMatchers(HttpMethod.GET,"/v1/student/**").hasAnyAuthority( 
					STUDENT_READ.name(),
					COURSE_READ.name())
			
			.antMatchers(HttpMethod.PUT,"/v1/student/**").hasAnyAuthority( 
					STUDENT_WRITE.name(),
					COURSE_WRITE.name())
			
			.antMatchers(HttpMethod.POST,"/v1/student/**").hasAnyAuthority( 
					STUDENT_WRITE.name(),
					COURSE_WRITE.name())
			
			.antMatchers(HttpMethod.DELETE,"/v1/student/**").hasAnyAuthority( 
					STUDENT_WRITE.name(),
					COURSE_WRITE.name())
			
			.antMatchers(HttpMethod.GET,"/v1/student/course/**").hasAnyAuthority(
					STUDENT_READ.name(),
					COURSE_READ.name())
			
			
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
	}
	
	
	@Override
	@Bean
	public UserDetailsService userDetailsServiceBean() throws Exception {
		UserDetails abhishekUser = User.builder().username("Abhishek").password(encoder.encode("password"))
					.authorities(ADMIN.getAuthority())
					.build();
		
		UserDetails sumiUser = User.builder().username("Sumi").password(encoder.encode("password123"))
					.authorities(STUDENT.getAuthority())
					.build();
		
		UserDetails hiteshUser = User.builder().username("Hitesh").password(encoder.encode("password123#"))
					.authorities(TRAINEE.getAuthority())
					.build();
		
		return new InMemoryUserDetailsManager(abhishekUser,sumiUser,hiteshUser);
	}
}
