//package com.abhi.app.auth;
//
//import static com.abhi.app.auth.UserRole.ADMIN;
//import static com.abhi.app.auth.UserRole.USER;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@EnableWebSecurity
//public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter{
// 
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.csrf().disable()
//			.authorizeRequests()
//			.antMatchers("/").permitAll()
//			.antMatchers("/v1/user/**").hasAnyRole(USER.name())
//			.antMatchers("/v1/admin/**").hasAnyRole(ADMIN.name())
//			.anyRequest()
//			.authenticated()
//			.and()
//			.formLogin();
//	}
//	
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder(20);
//	}
//	
//	@Override
//	@Bean
//	protected UserDetailsService userDetailsService() {
//		UserDetails adminUser = User.builder()
//					.username("abhishek").password(passwordEncoder().encode("password"))
//					.roles(ADMIN.name())
//					.build();
//		
//		UserDetails lindaUser = User.builder()
//				.username("linda").password(passwordEncoder().encode("password123"))
//				.roles(USER.name())
//				.build();
//		
//		return new InMemoryUserDetailsManager(adminUser,lindaUser);
//	}
//}
