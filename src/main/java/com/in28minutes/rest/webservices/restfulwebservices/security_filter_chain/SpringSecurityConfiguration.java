package com.in28minutes.rest.webservices.restfulwebservices.security_filter_chain;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//1. All requests should be authenticated. 
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
				);
		//2. If any request is not authenticated the login web page will be shown
		http.httpBasic(withDefaults());
		//3. CSRF -> POST, PULL disabled
		http.csrf().disable();
		return http.build();
	}
}
