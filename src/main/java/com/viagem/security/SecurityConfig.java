package com.viagem.security;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;



import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@Component
public class SecurityConfig {

	private final CustomUserDetailsService myUserDetailsService;

	public SecurityConfig(CustomUserDetailsService myUserDetailsService) {
		this.myUserDetailsService = myUserDetailsService;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable().authorizeRequests(auth -> auth
				.antMatchers("/", "/create", "/home", "/login", "/register", "/usuarios/acesso", "/usuarios/create",
						"/usuarios/acesso", "api/promocao", "api/destino", "api/clientes", "api/compras")
				.permitAll().anyRequest().authenticated()).userDetailsService(myUserDetailsService)
				.headers(headers -> headers.frameOptions().sameOrigin()).httpBasic(withDefaults()).build();
	}

}
