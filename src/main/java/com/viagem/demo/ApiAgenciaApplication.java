package com.viagem.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = { "com.viagem.model.entity" })
@EnableJpaRepositories(basePackages = { "com.viagem.repositories" })
@ComponentScan(basePackages = { "com.viagem.controller", "com.viagem.services", "com.viagem.services.impl" })
@SpringBootApplication
public class ApiAgenciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAgenciaApplication.class, args);
	}

}
