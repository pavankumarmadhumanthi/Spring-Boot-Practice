package com.example.Services;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class HttpUrlSecurity {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				(authorize) -> authorize.requestMatchers("/contactus", "/").permitAll().anyRequest().authenticated())
				.httpBasic(withDefaults()).formLogin(withDefaults());
		return http.build();

	}

	public InMemoryUserDetailsManager userDetails() {
		UserDetails pavan = User.withDefaultPasswordEncoder().username("pavan").password("pavan").authorities("USER").build();
	
		return new InMemoryUserDetailsManager(pavan);
		
	}
}
