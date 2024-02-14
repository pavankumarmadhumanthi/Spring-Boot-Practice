package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class AppConfig {

//	@Autowired
//	private PasswordEncoder encode;

	@Bean
	public UserDetailsService userDetails(PasswordEncoder encode) {
		UserDetails admin = User.withUsername("pavan").password(encode.encode("pavan")).roles("ADMIN").build();
		UserDetails user = User.withUsername("raju").password(encode.encode("raju")).roles("USER").build();
		return new InMemoryUserDetailsManager(admin, user);
	}

	@Bean
	public PasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterUrl(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests().requestMatchers("/welcome").permitAll()
		.and()
		.authorizeHttpRequests()
		.requestMatchers("/**").authenticated().and().formLogin();
		return http.build();
	}
}
