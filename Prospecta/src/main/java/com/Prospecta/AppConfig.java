package com.Prospecta;


import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.web.SecurityFilterChain;

import org.springframework.stereotype.Controller;

@Configuration
public class AppConfig {
	
	@Bean
	public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests().requestMatchers(HttpMethod.POST, "/entries").permitAll().anyRequest()
				.authenticated().and().csrf().disable().formLogin().and().httpBasic();

		return http.build();

	}
	
}
