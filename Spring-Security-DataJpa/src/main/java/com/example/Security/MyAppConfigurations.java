package com.example.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.Services.DataProvider;

@Configuration
@EnableWebSecurity
public class MyAppConfigurations {
	@Autowired
	private DataProvider provider;

	@Bean
	PasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	AuthenticationProvider provider() {
		DaoAuthenticationProvider AuthProvider = new DaoAuthenticationProvider();
		AuthProvider.setUserDetailsService(provider);
		AuthProvider.setPasswordEncoder(encode());
		return AuthProvider;
	}

	@Bean
	AuthenticationManager getAuthManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();

	}

	@Bean
	SecurityFilterChain filterUrlAccess(HttpSecurity http) throws Exception {
		return http.csrf().disable().authorizeHttpRequests().requestMatchers("/register", "/login").permitAll().and()
				.authorizeHttpRequests().requestMatchers("/welcome").authenticated().and().build();
	}
}
